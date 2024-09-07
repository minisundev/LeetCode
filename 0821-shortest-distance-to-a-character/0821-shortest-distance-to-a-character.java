class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        int closest_c = Integer.MAX_VALUE; 

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                closest_c = i;
            }
            answer[i] = Math.abs(i - closest_c);
        }

        closest_c = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                closest_c = i;
            }
            answer[i] = Math.min(answer[i], Math.abs(i - closest_c));
        }

        return answer;
    }
}
