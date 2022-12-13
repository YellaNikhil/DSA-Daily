class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for(int row = 1;row < rows;row++){
            for(int col = 0;col < cols; col++){
                int leftDiag = col - 1, rightDiag = col + 1;
                int val = matrix[row-1][col];
                if(leftDiag >= 0){
                    val = Math.min(val, matrix[row-1][leftDiag]);
                }
                if(rightDiag < cols){
                    val = Math.min(val, matrix[row-1][rightDiag]);
                }
                matrix[row][col] += val;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int col=0;col<cols;col++){
            result = Math.min(result, matrix[rows-1][col]);
        }
        return result;
    }
}