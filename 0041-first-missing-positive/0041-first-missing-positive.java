import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        //0인 부분을 upperbound로 찾기
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = (low+high)/2;

            if(nums[mid]<0){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        int last = nums[high];
        if(last>1 || last<0){
            return 1;
        }

        System.out.println(high);

        for(int i=high; i<nums.length; i++){
            int now = nums[i];
            if(now-last>1){
                break;
            }
            last = now;
        }
        return last+1;
    }
}