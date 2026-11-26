class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0) return 0;

        int max = 0;

        //count
        Set<Character> set = new HashSet<>();

        //last index
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while(right<s.length()){
            char c = s.charAt(right);

            map.put(c,right);
            set.add(c);

            // 아 제거 로직이 바로 다음 글자가 아니고, 
            // last 출현이 2번째로 나중에 끝나는 원소부터 뺐어야 하는 거구만 ㅎ 하나는 유지가 가능하니깐
            if(set.size()>k){
                List<Character> list = new ArrayList<>(set);

                Collections.sort(list,(o1,o2)->{
                    return map.get(o1)-map.get(o2);
                });

                char first = list.get(0);
                int firstIdx = map.get(first);
                //System.out.println("update left: "+left+" -> "+ (firstIdx+1));

                left = firstIdx+1; 
                //System.out.println("remove set: "+map.get(first)+" @right: "+ right);
                set.remove(first);
            }

            max = Math.max(right-left+1,max);
            //System.out.println("max: "+max+" @right: "+ right);
            right++;
        }

        return max;
    }
}