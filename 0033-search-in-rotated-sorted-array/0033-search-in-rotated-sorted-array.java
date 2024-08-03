class Solution {
    public int search(int[] nums, int target) {

        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }
            else{
                return -1;
            }
        }

        int pivot = 0;
        int standard = nums[0];

        int low = 0;
        int high = nums.length -1;

        while(low<=high){
            pivot = (low+high)/2;

            int num = nums[pivot];

            if(standard < num){
                low = pivot+1;
            }else{
                high = pivot-1;
            }
        }

        low = 0;
        high = nums.length -1;

        while(low <= high){
            int mid = ((low+high)/2+pivot)%(nums.length -1);

            int num = nums[mid];

            if(num > target){
                high = mid -1;
            }else if(num < target){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}