class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        int standard = nums[0];

        //upperbound
        while(low<high){
            int mid = (low+high)/2;

            if(nums[mid]>=standard){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        if(high == nums.length-1 && nums[high] >= standard){
            return nums[0];
        }
        return nums[high];
    }
}