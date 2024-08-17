import java.lang.Math;

class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;

        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.min(nums[0],nums[1]);  

        int answer = nums[0];
        
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==nums[left] && nums[mid]==nums[right]){
                answer = Math.min(answer, nums[mid]);
                left++;
                right--;
                continue;
            }

            if(nums[mid]>=nums[left]){
                answer = Math.min(answer,nums[left]);
                left = mid+1;
            }else{
                answer = Math.min(answer,nums[mid]);
                right = mid-1;
            }
        }
        return answer;
    }
}