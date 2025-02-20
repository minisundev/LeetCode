class Solution {
    List<List<Integer>> list = new ArrayList<>();

    int[][] arr;
    boolean[][] atlantic;
    boolean[][] pacific;
    boolean[][] visit;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        arr = heights;
        atlantic = new boolean[heights.length][heights[0].length];
        pacific = new boolean[heights.length][heights[0].length];
        visit = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                visit[i][j] = true;
                search(i, j);

                if (atlantic[i][j] && pacific[i][j]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    list.add(pair);
                }

                visit[i][j] = false;
            }
        }
        return list;
    }

    int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    // backtracking dfs
    void search(int x, int y) {
        if (x == 0 || y == 0) {
            pacific[x][y] = true;
        }
        if (x == arr.length - 1 || y == arr[0].length - 1) {
            atlantic[x][y] = true;
        }

        if (pacific[x][y] && atlantic[x][y]) {
            return;
        }

        for (int[] d : dir) {
            int X = x + d[0];
            int Y = y + d[1];
            if (X >= 0 && Y >= 0 && X < arr.length && Y < arr[0].length && arr[X][Y] <= arr[x][y]) {
                if (pacific[X][Y]) {
                    pacific[x][y] = true;
                }
                if (atlantic[X][Y]) {
                    atlantic[x][y] = true;
                }

                if (pacific[x][y] && atlantic[x][y]) {
                    return;
                }

                if (!visit[X][Y]) {
                    visit[X][Y] = true;

                    search(X, Y);
                    if (pacific[X][Y]) {
                        pacific[x][y] = true;
                    }
                    if (atlantic[X][Y]) {
                        atlantic[x][y] = true;
                    }

                    visit[X][Y] = false;
                }
            }
        }
    }
}