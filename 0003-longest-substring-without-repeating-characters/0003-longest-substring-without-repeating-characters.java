class Solution {
    public int lengthOfLongestSubstring(String s) {
        //슬라이딩 윈도우인가?!
        //마지막 인덱스 저장하는 해쉬맵이 있어서 거기까지 가버리는것임~!
        if(s==null || s.length()==0){
            return 0;
        }
        int max = 1;
        Set<Character> set = new HashSet<>();
        int left = 0;
        set.add(s.charAt(0));
        for(int right=1;right<s.length();right++){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left++));
            }
            set.add(c);
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}