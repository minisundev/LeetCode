class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    private int countAtMost(int[] nums, int k) {
        if (k < 0)
            return 0;

        int left = 0;
        int sum = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left++];
            }
            result += (right - left + 1);
        }
        return result;
    }

}