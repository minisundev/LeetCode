class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Set <Integer> set = new HashSet<>();

        for(int num : nums){
            int count = map.getOrDefault(num,0);
            count++;
            map.put(num,count);
            if(count==1){
                set.add(num);
            }else if(count==3){
                set.remove(num);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        return list.get(0);
    }
}