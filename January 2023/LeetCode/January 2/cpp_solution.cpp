class Solution {
public:
    bool detectCapitalUse(string word) {
        int capitals = 0;
        for(int i=0;i<word.length();i++){
            char ch = word[i];
            if(ch>='A' && ch<='Z'){
                capitals++;
            }
        }
        bool firstCh = word[0] >='A' && word[0]<='Z';
        return capitals==word.length() || (capitals==1 && firstCh) || capitals==0;
    }
};