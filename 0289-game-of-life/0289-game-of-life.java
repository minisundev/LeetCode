class Solution {
    public void gameOfLife(int[][] board) {
        int[][] next = new int[board.length][board[0].length];
        // 생존 이웃 2 미만 -> 죽음
        // 2~3명의 생존 이웃 -> 생존
        // 3 초과 이웃 생존 -> 죽음
        // 3 생존 이웃 -> 부활
        // 누적합 도입하면 좀 빠르지 않을까~
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int alive = count(i, j, board);
                if (board[i][j] == 0) {
                    if (alive == 3) {
                        next[i][j] = 1;
                    }
                    continue;
                } else {
                    if (alive < 2 || alive > 3) {
                        next[i][j] = 0;
                    } else if (alive <= 3 && alive >= 2) {
                        next[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = next[i][j];
            }
        }
    }

    int count(int x, int y, int[][] board) {
        int alive = 0;
        int dead = 0;

        int startX = Math.max(x - 1, 0);
        int endX = Math.min(x + 1, board.length - 1);
        int startY = Math.max(y - 1, 0);
        int endY = Math.min(y + 1, board[0].length - 1);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (x == i && y == j) {
                    continue;
                }
                if (board[i][j] == 1) {
                    alive++;
                } else {
                    dead++;
                }
            }
        }

        //System.out.println(startX + " " + endX + " " + startY + " " + endY + " alive:" + alive);
        return alive;
    }
}