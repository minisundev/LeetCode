class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            Integer pair = map.getOrDefault(target-n,null);
            //System.out.println("n:"+n+" ,pair:"+pair);
            if(pair!=null){
                return new int[]{i,pair};
            }
            map.put(n,i);
        }
        return new int[]{0,0};
    }
}