class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = (low+high)/2;

        while(low<=high){
            mid = (low+high)/2;

            if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                return mid;//찾음
            }
        }
        if(nums[mid]<target){
            mid++;
        }
        return mid;//이거 다음에 들어감
    }
}