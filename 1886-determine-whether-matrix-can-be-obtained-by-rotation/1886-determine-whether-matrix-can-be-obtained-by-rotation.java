class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        //3번 90도로 돌려보면서~ 타겟과 같아지는지 본다?
        if(compare(mat,target)) return true;
        for(int i=0; i<3; i++){
            mat = rotate(mat);
            if(compare(mat,target)) return true;
        }
        return false;
    }

    int [][] rotate(int [][] arr){
        int [][] rotated = new int [arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr[0].length; j++){
                rotated[j][arr.length-1-i] = arr[i][j];
            }
        }
        return rotated;
    }

    boolean compare(int [][] arr, int [][] target){
        for(int i=0; i<target.length; i++){
            for(int j=0; j<target[0].length; j++){
                if(arr[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }
}