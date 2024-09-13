import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        
        Arrays.sort(nums);
        int answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int target = nums[i] + k;
            if (binarySearch(nums, i + 1, nums.length - 1, target)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}