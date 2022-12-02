class Solution {
    public :
	bool closeStrings(string word1, string word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int alphasOfWord1[26], alphasOfWord2[26];
	memset(alphasOfWord1, 0, sizeof(alphasOfWord1));
	memset(alphasOfWord2, 0, sizeof(alphasOfWord2));
        int index = 0, length = word1.length();
        while(index < length){
            alphasOfWord1[word1[index]-'a']++;
            alphasOfWord2[word2[index]-'a']++;
            index++;
        }
        for(int alphaIndex = 0;alphaIndex < 26;alphaIndex++){
            if(alphasOfWord1[alphaIndex]> 0 && alphasOfWord2[alphaIndex]> 0 && alphasOfWord1[alphaIndex] == alphasOfWord2[alphaIndex]){
                alphasOfWord1[alphaIndex] = alphasOfWord2[alphaIndex] = 0;
                // System.out.println(alphaIndex);
            }
        }
        for(int alphaIndex = 0;alphaIndex<26;alphaIndex++){
            if(alphasOfWord1[alphaIndex] > 0){
                    bool change = false;
                    for(int nextIndex = 0;nextIndex < 26;nextIndex++){
                        // checking if for present character there is a character in word2 that has same count and also that char present in word1 as well.
                        if(alphasOfWord2[nextIndex] == alphasOfWord1[alphaIndex]){
                            if((alphasOfWord1[nextIndex] == -1 || alphasOfWord1[nextIndex] > 0) || 
                            (alphasOfWord2[alphaIndex] == - 1|| alphasOfWord2[alphaIndex] > 0)){
                                alphasOfWord1[alphaIndex] = alphasOfWord2[nextIndex] = -1;
                                change = true;
                                break;
                            }
                        }
                    }
                    if(!change){
                        return false;
                    }
            }
        }
        return true;
    }
};