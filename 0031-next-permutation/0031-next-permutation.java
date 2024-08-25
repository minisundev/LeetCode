import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n==1){
            return;
        }

        // 처음으로 오름차순 깨지는 부분 찾음
        int target = n-2;
        while (target >= 0 && nums[target] >= nums[target+1]){
            target--;
        }

        // target보다 크면서 가장 작은 것 찾음
        if (target>=0){
            int min = n-1;
            while (nums[min] <= nums[target]){
                min--;
            }
            swap(nums, target, min);
        }

        reverse(nums, target+1, n-1);
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 이게 투포인터 문제인 이유
    void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}