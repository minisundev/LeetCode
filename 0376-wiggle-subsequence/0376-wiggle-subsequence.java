class Solution {
    public int wiggleMaxLength(int[] nums) {
        // state 를 다루는 또 다른 dp 문제~
        // up => down => up => down => up => down

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {//올라갔어
                up[i] = down[i - 1] + 1;//이전에 내려간것까지의 길이+1
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {//내려갔어
                down[i] = up[i - 1] + 1;//이전에 올라간것까지의 길이+1
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }

        return Math.max(up[nums.length-1], down[nums.length-1]);
    }
}