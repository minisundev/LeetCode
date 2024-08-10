class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pivot;

        if(nums[0]==nums[nums.length-1]){
            pivot = nums.length-1;
            while(nums[high]>=nums[pivot] && pivot>0){
                pivot--;
            }
            pivot++;
        }
        else{
            while (low < high) {
                int mid = (low + high) / 2;
                System.out.println(low+","+high+","+mid+":"+nums[mid]);
                if (nums[mid] > nums[high]) {
                    low = mid + 1; 
                } else if (nums[mid] < nums[high]) {
                    high = mid; 
                } else { 
                    high--; 
                }
            }
            pivot = low;
        }

        low = 0;
        high = nums.length - 1;

        System.out.println(pivot);
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int realMid = (mid + pivot) % nums.length;

            System.out.println(low+","+high+","+mid+":"+nums[realMid]);
            
            if (nums[realMid] == target) {
                return true;
            } else if (nums[realMid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return false;
    }
}
