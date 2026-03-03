class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //sliding window네...
        long sum = 0L;
        int left = 0;
        int right = 0;
        long max = Long.MIN_VALUE;
        for(; right<nums.length && right<k; right++){
            sum += nums[right];
        }

        max = Math.max(max,sum);

        for(; right<nums.length; right++){
            sum += nums[right];
            sum -= nums[left++];
            max = Math.max(max,sum);
        }

        return (double)max/k;
    }
}