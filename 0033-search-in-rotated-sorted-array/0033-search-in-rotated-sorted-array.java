class Solution {
    public int search(int[] nums, int target) {
        
        int pivot = -1;

        int low = 0;
        int high = nums.length-1;

        int standard = nums[0];

        //lowerbound
        while(low<high){
            int mid = (low+high)/2;

            //올려라, 같거나 (0에 있으면 0...)크면
            if(nums[mid]>=standard){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        pivot = low;
        System.out.println(pivot);

        low = 0;
        high = nums.length-1;

        while(low<=high){
            int mid = (low+high)/2;
            int realmid = (mid+pivot)%nums.length;

            if(nums[realmid]>target){
                high = mid-1;
            }else if(nums[realmid]<target){
                low = mid+1;
            }else{
                return realmid;
            }
        }

        System.out.println("low "+low+"high "+high);

        try{
            if(nums[low%nums.length]==target){
                return low;
            }
            if(nums[high%nums.length]==target){
                return high;
            }
        }catch(Exception e){
            return -1;
        }
        return -1;
    }
}