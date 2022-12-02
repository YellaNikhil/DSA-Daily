class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()){
            return false;
        }
        int[] alphasOfWord1 = new int[26], alphasOfWord2 = new int[26];
        Arrays.fill(alphasOfWord1, 0);
        Arrays.fill(alphasOfWord2, 0);
        int index = 0, length = word1.length();
        while(index < length){
            alphasOfWord1[word1.charAt(index)-'a']++;
            alphasOfWord2[word2.charAt(index)-'a']++;
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
                    boolean change = false;
                    for(int nextIndex = 0;nextIndex < 26;nextIndex++){
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
}