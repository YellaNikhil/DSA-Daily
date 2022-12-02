class Solution {
    int isItPossible(String S, String T, int M, int N) {
        // code here
        int i = 0, j = 0, countAlphas = 0;
        while(i < M){
            if(S.charAt(i)!='#'){
                countAlphas++;
            }
            i++;
        }
        while(j < N){
            if(T.charAt(j)!='#'){
                countAlphas--;
            }
            j++;
        }
        if(countAlphas!=0){//if count is not similar in both strings
            return 0;
        }
        i = 0;j = 0;
        while(i < M && j < N){
            // Check for next A or B
            while(i < M && S.charAt(i)=='#'){
                i++;
            }
            while(j < N && T.charAt(j)=='#'){
                j++;
            }
            if(i < M && j < N){
                if(S.charAt(i) != T.charAt(j)){// if both characters are not equal 
                    return 0;
                }
                //As 'A' can only be moved to left if index of S less than index of T it cannot move
                if(S.charAt(i) == 'A' && i < j){
                    return 0;
                }
                //As 'B' can only be moved to right if index of S greater than index of T it cannot move
                if(S.charAt(i)=='B' && i > j){
                    return 0;
                }
            }
            i++; 
            j++;
        }
        return 1;
    }
};