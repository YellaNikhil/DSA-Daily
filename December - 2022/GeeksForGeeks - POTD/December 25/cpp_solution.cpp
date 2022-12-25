int n = matrix.size();
        long long diag1 = 0, diag2 = 0;
        int zeroRow = 0, zeroCol = 0;
        long long sums[2][n];
        memset(sums, 0, sizeof(sums));
        for(int i=0;i<n;i++){
            diag1 += matrix[i][i];
            diag2 += matrix[i][n-1-i];
            for(int j=0;j<n;j++){
                sums[1][j] += matrix[i][j];
                sums[0][i] += matrix[i][j];
                if(matrix[i][j]==0){
                    zeroCol = j;
                    zeroRow = i;
                }
            }
        }
        long long val = sums[0][(zeroRow + 1)%n] - sums[0][zeroRow];
        if(val <=0 || val != (sums[1][(zeroCol+1)%n] - sums[1][zeroCol])){
            return -1;
        }
        sums[0][zeroRow] += val;
        sums[1][zeroCol] += val;
        if(zeroRow == zeroCol){
            diag1 += val;
        }
        if(zeroRow == (n - 1 - zeroCol)){
            diag2 += val;
        }
        if(diag1!=diag2){
            return -1;
        }
        for(int i=0;i<n;i++){
            if(sums[0][i]!=diag1){
                return -1;
            }
            if(sums[1][i]!=diag1){
                return -1;
            }
        }
        return val;