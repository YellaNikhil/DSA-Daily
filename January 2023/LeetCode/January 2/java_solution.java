class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ch>='A' && ch<='Z'){
                capitals++;
            }
        }
        boolean firstCh = word.charAt(0) >='A' && word.charAt(0)<='Z';
        return capitals==word.length() || (capitals==1 && firstCh) || capitals==0;
    }
}