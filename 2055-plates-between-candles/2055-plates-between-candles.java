class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] answer = new int[queries.length];

        int[] plates = new int[n];
        int[] lastCandle = new int[n];
        int[] nextCandle = new int[n];

        plates[0] = s.charAt(0) == '*' ? 1 : 0;
        int last = -1;
        for (int i = 1; i < n; i++) {
            plates[i] = plates[i - 1] + (s.charAt(i) == '*' ? 1 : 0);
            if (s.charAt(i) == '|') last = i;
            lastCandle[i] = last;
        }

        int next = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') next = i;
            nextCandle[i] = next;
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            int start = nextCandle[left];
            int end = lastCandle[right];

            if (start != -1 && end != -1 && start < end) {
                answer[i] = plates[end] - plates[start];
            }
        }

        return answer;
    }
}
