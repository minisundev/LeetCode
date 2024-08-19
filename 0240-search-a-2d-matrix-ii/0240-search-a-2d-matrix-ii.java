class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // 타겟보다 크면 왼쪽으로 이동
            } else {
                row++; // 타겟보다 작으면 아래로 이동
            }
        }

        return false; // 찾지 못했으면 false 반환
    }
}
