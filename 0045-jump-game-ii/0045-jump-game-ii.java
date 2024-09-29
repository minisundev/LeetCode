class Solution {

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;

        int maxReach = 0, steps = 0, lastJumpedPos = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == lastJumpedPos) {
                steps++;
                lastJumpedPos = maxReach;
                if (lastJumpedPos >= nums.length - 1) {
                    break;
                }
            }
        }

        return steps;
    }
}
