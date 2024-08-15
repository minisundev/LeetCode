class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (sums[mid] - sums[i] >= target) {
                    minLen = Math.min(minLen, mid - i);
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
