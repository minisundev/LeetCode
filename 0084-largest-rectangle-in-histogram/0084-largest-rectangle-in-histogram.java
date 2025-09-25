class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            
            // pop할 때 그 높이로 사각형 계산!
            while (!dq.isEmpty() && heights[dq.peekLast()] > h) {
                int poppedIdx = dq.pollLast();
                int poppedHeight = heights[poppedIdx];
                int width = dq.isEmpty() ? i : i - dq.peekLast() - 1;
                max = Math.max(max, poppedHeight * width);
            }
            
            // 현재 높이로만 계산 (이상한 로직 제거)
            dq.offerLast(i);
        }
        
        // 마지막에 남은 것들 처리
        while (!dq.isEmpty()) {
            int poppedIdx = dq.pollLast();
            int poppedHeight = heights[poppedIdx];
            int width = dq.isEmpty() ? heights.length : heights.length - dq.peekLast() - 1;
            max = Math.max(max, poppedHeight * width);
        }
        
        return max;
    }
}