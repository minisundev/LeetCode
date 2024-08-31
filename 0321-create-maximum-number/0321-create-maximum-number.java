import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxNumber = new int[k];
        
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxSubarray(nums1, i), maxSubarray(nums2, k - i), k);
            if (greater(candidate, 0, maxNumber, 0)) {
                maxNumber = candidate;
            }
        }
        
        return maxNumber;
    }

    private int[] maxSubarray(int[] nums, int k) {
        int[] stack = new int[k];
        int len = nums.length;
        int top = 0; 
        int drop = len - k; 
        
        for (int num : nums) {
            while (top > 0 && stack[top - 1] < num && drop > 0) {
                top--;
                drop--;
            }
            if (top < k) {
                stack[top++] = num;
            } else {
                drop--;
            }
        }
        
        return stack;
    }

    int[] merge(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        int i = 0;
        int j = 0;
        int r = 0;
        
        while (r < k) {
            if (greater(nums1, i, nums2, j)) {
                result[r++] = nums1[i++];
            } else {
                result[r++] = nums2[j++];
            }
        }
        
        return result;
    }

    boolean greater(int[] nums1, int i, int[] nums2, int j) {
        int m = nums1.length, n = nums2.length;
        while (i < m && j < n && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == n || (i < m && nums1[i] > nums2[j]);
    }
}
