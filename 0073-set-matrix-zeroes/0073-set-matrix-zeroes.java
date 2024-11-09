class Solution {
    public void setZeroes(int[][] matrix) {
        boolean [] rows = new boolean [matrix.length];
        boolean [] cols = new boolean [matrix[0].length];
        //또 mn으로 for문 두번 돌리면 안 된다고 함 ㅎㅎㅎㅎ.... for문 두번도 n이.. 아니겠지
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    rows[i] = true;
                    cols[j] = true;
                    //이전것을 해줘야 해...
                    for(int i2=i-1;i2>=0;i2--){
                        matrix[i2][j]=0;
                    }
                    for(int j2=j-1;j2>=0;j2--){
                        matrix[i][j2] = 0;
                    }
                }else{
                    if(rows[i]){
                        matrix[i][j]=0;
                    }else if(cols[j]){
                        matrix[i][j]=0;
                    }
                }
            }
        }
    }
}