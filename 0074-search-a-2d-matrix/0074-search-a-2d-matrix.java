
class Solution {

    int length;
    int collength;

    public boolean searchMatrix(int[][] matrix, int target) {
        length = matrix.length;
        collength = matrix[0].length;

        int low = 0;
        int high = length * collength - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int row = mid / collength;
            int col = mid % collength;

            int value = matrix[row][col];

            if(value > target){
                high = mid - 1;
            } else if(value < target){
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}


