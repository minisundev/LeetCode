import java.util.*;
import java.lang.Math;

class Solution {
    
    public int numSquares(int n) {
        if (n <= 0) return 0;

        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(n);
        visited[n] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int remainder = queue.poll();
                
                for (int square : squares) {
                    int next = remainder - square;

                    if (next == 0) {
                        return steps;
                    }
                    
                    if (next > 0 && !visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return steps;
    }
}

