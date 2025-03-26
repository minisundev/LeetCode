public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int stick : matchsticks) {
            total += stick;
        }
        
        if (total % 4 != 0) return false;
        
        int target = total / 4;
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        int[] sides = new int[4];
        return dfs(matchsticks, sides, 0, target);
    }
    
    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    private boolean dfs(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
        
        int stick = matchsticks[index];
        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick > target) continue;
            
            if (i > 0 && sides[i] == sides[i-1]) continue;
            
            sides[i] += stick;
            
            if (dfs(matchsticks, sides, index + 1, target)) {
                return true;
            }
            
            sides[i] -= stick;
        }
        
        return false;
    }
}