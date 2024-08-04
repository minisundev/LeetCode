class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int upperbound = -1;
        int lowerbound = -1;

        int low = 0;
        int high = nums.length-1;

        //upperbound
        while(low<high){
            int mid = (low+high)/2;

            //올린다, 작거나 같을 때만
            if(nums[mid]<=target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        upperbound = high;

        //lowerbound
        low = 0;
        high = nums.length-1;

        while(low<high){
            int mid = (low+high)/2;

            //올린다, 작을 때만
            if(nums[mid]<target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        lowerbound = low;

        try{
            if(nums[lowerbound] == target){
                if(nums[upperbound]==target){
                    return new int [] {lowerbound, upperbound};
                }else if(nums[upperbound-1]==target){
                    return new int [] {lowerbound, upperbound-1};
                }
                
            }
        }
        catch(Exception e){
            return new int [] {-1,-1};
        }
        return new int [] {-1,-1};
    }
}