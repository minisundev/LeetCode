import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(nums[0], map.getOrDefault(nums[0], 0) + 1);
        map.put(-nums[0], map.getOrDefault(-nums[0], 0) + 1);

        for (int i = 1; i < nums.length; i++) {
            int element = nums[i];
            Map<Integer, Integer> newMap = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int sum = entry.getKey();
                int count = entry.getValue();

                newMap.put(sum + element, newMap.getOrDefault(sum + element, 0) + count);
                newMap.put(sum - element, newMap.getOrDefault(sum - element, 0) + count);
            }

            map = newMap;
        }

        return map.getOrDefault(target, 0);
    }
}