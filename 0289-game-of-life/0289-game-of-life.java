class Solution {
    int[][] board;
    int n;
    int m;
    
    public void gameOfLife(int[][] board) {
        n = board.length;
        m = board[0].length;
        //내가 살아있을때) 산 이웃이 2~3 보다 적어도 죽고 많아도 죽는다!
        //내가 죽어있을때) 산 이웃이 정확히 3명이면 다시 살아남
        
        this.board = board;
        int[][] sum = new int[n+2][m+2];
        
        sum[1][1] = board[0][0];
        
        for(int i = 2; i <= n; i++) {
            sum[i][1] = sum[i-1][1] + board[i-1][0];
        }
        
        for(int j = 2; j <= m; j++) {
            sum[1][j] = sum[1][j-1] + board[0][j-1];
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + board[i-1][j-1];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                //flip 계산
                int count = 0;//1이 몇개니~
                
                // board[i][j]의 3x3 영역: board 기준 (i-1 ~ i+1, j-1 ~ j+1)
                // sum 배열 기준으로는 (i ~ i+2, j ~ j+2) 범위인데 경계 체크 필요
                int r1 = Math.max(0, i - 1) + 1;  // sum[1] ~ sum[n]
                int c1 = Math.max(0, j - 1) + 1;
                int r2 = Math.min(n - 1, i + 1) + 1;
                int c2 = Math.min(m - 1, j + 1) + 1;
                
                count = sum[r2][c2] - sum[r1-1][c2] - sum[r2][c1-1] + sum[r1-1][c1-1];
                
                count -= board[i][j];
                
                if(board[i][j] == 1) {
                    //살아있을때는 2~3개 아니면 죽이면 됨
                    if(count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    //죽어있을때는 딱 3개면 살리면 됨
                    if(count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}