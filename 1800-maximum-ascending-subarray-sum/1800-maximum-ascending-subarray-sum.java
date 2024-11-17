class Solution {
    public int maxAscendingSum(int[] nums) {

        int max = 0;
        int last = nums[0];
        int sum = last;
        for(int i=1; i<nums.length; i++){
            int num = nums[i];
            if(last<num){
                sum += num;
            }else{
                max = Math.max(max,sum);
                sum = num;
            }
            last = num;
        }
        max = Math.max(max,sum);
        return max;
    }
}