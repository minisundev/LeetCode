
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> graph; 
    boolean[] visited; 
    boolean[] onPath; 

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); 
        }

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i)) {
                return false; 
            }
        }

        return true; // 사이클이 없으면 모두 이수 가능
    }

    // DFS로 사이클 확인
    private boolean hasCycle(int course) {
        if (onPath[course]) return true; // 이미 탐색 경로에 있다면 사이클이 있음
        if (visited[course]) return false; // 이미 방문한 노드라면 사이클이 아님

        // 노드를 방문 처리하고, 현재 경로에 추가
        visited[course] = true;
        onPath[course] = true;

        // 인접한 노드들 탐색
        for (int neighbor : graph.get(course)) {
            if (hasCycle(neighbor)) {
                return true; // 인접한 노드에서 사이클이 있으면 true 반환
            }
        }

        // 경로에서 제거
        onPath[course] = false;

        return false; // 사이클이 없음
    }
}
