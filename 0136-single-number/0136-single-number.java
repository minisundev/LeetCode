class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for(int num : nums){
            if(!set.contains(num)){
                set.add(num);
            }else{
                set.remove(num);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        return list.get(0);
    }
}