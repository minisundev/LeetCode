
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
            Coord c = convertToCoord(mid);

            int value = matrix[c.row][c.col];
            System.out.println(c.row + "," + c.col + " " + value);
            System.out.println(low + "," + high);

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

    Coord convertToCoord(int position){
        int row = position / collength;
        int col = position % collength;
        return new Coord(row, col);
    }
}

class Coord{
    public int row;
    public int col;
    public Coord(int row, int col){
        this.row = row;
        this.col = col;
    }
}

