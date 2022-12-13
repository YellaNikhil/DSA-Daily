class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int rows = matrix.size(), cols = matrix[0].size();
        for(int row = 1;row < rows;row++){
            for(int col = 0;col < cols; col++){
                int leftDiag = col - 1, rightDiag = col + 1;
                int val = matrix[row-1][col];
                if(leftDiag >= 0){
                    val = min(val, matrix[row-1][leftDiag]);
                }
                if(rightDiag < cols){
                    val = min(val, matrix[row-1][rightDiag]);
                }
                matrix[row][col] += val;
            }
        }
        int result = INT_MAX;
        for(int col=0;col<cols;col++){
            result = min(result, matrix[rows-1][col]);
        }
        return result;
    }
};