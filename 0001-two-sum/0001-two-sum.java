import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // int [] result = new int[2];

        // Arrays.sort(nums);
        //  int left = 0;
        //  int right = nums.length-1;

        //  while(left<right){
        //     if(nums[left]+nums[right]<target){
        //         left++;
        //     }else if(nums[left]+nums[right]>target){
        //         right--;
        //     }else{
        //         result[0] = left;
        //         result[1] = right;
        //         return result;
        //     }
        //  }

        //  return result;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return null;
        
    }
}