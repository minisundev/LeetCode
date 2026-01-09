class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){ 
            int num = nums[i];
            sum += num;
            if(sum==k) count++;
            int target = map.getOrDefault(sum-k,0);
            count += target;
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}