class Solution {
    int [][] arr;
    boolean [][] visit;

    public void rotate(int[][] matrix) {
        //가장자리 크기에 따라서 재귀적일 것 같다
        //한 변에서 차지하는 상대 위치에 따라서 4개씩 쌍으로 바꾸면 될 것 같음
        int n = matrix.length;
        int m = matrix[0].length;
        arr = matrix;
        visit = new boolean [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j]){
                    //System.out.print("X");
                    continue;
                }
                //System.out.print("O");

                //흠 0~i gap을 j에다 띄워야 할때가 있고 그런것임
                //2
                int x1 = i;//0 //0
                int y1 = j;//0 //1
                
                //6
                int x3 = j;//0 //1
                int y3 = (n-1)-i;//2 //2
                
                //8
                int x7 = (n-1)-j;//2 //2
                int y7 = i;//0 //1
                
                //4
                int x9 = (n-1)-i;//2 //1
                int y9 = (n-1)-j;//2 //0

                swap(x1,y1,x3,y3,x7,y7,x9,y9);
                //print();
            }
            //System.out.println();
        }
    }

    void print(){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    void swap(int x1, int y1, int x3, int y3, int x7, int y7, int x9, int y9){
        int temp = arr[x1][y1];
        //좌
        arr[x1][y1] = arr[x7][y7];
        //하
        arr[x7][y7] = arr[x9][y9];
        //우
        arr[x9][y9] = arr[x3][y3];
        //상
        arr[x3][y3] = temp;
        visit[x1][y1] = true;
        visit[x3][y3] = true;
        visit[x7][y7] = true;
        visit[x9][y9] = true;
    }
}