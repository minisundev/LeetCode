import java.lang.Math;
import java.util.*;

class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<=1){
            return 0;
        }

        Arrays.sort(nums);//정렬 안 하고 O(n)만으로 어떻게 풀 수 있는게 있나...

        int last = nums[0];
        int max = Math.abs(nums[1]-nums[0]);

        for(int i=2;i<nums.length;i++){
            int gap = Math.abs(nums[i]-nums[i-1]);
            max = Math.max(max,gap);
        }

        return max;
    }
}