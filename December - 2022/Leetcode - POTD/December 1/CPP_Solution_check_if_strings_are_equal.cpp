class Solution {
public:
    bool checkIfPresent(char ch){
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
        return false;
    }
    bool halvesAreAlike(string S) {
        int countOfVowels = 0;
        int i = 0;
        for(i=0;i<S.length()/2;i++){
            char ch = S[i];
            if(checkIfPresent(ch)){
                countOfVowels++;
            }
        }
        for(i=S.length()/2;i<S.length();i++){
            char ch = S[i];
            bool pos = checkIfPresent(ch);
            if(pos){
                countOfVowels--;
            }
        }
        return countOfVowels==0;
    }
};