class NumArray {
    //그냥 prefix sum이잖아
    int [] sums;

    public NumArray(int[] nums) {
        sums = new int [nums.length+1];
        sums[0] = 0;
        sums[1] = nums[0];
        for(int i=2; i<sums.length; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return sums[right+1]-sums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */