class Solution{
    private int checkVowel(char C){
        switch(C){
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case 'o':
                return 3;
            case 'u':
                return 4;
            default:
                break;
        }
        return -1;
    }
    private char findVowel(int index){
        switch(index){
            case 0:
                return 'a';
            case 1:
                return 'e';
            case 2:
                return 'i';
            case 3:
                return 'o';
            case 4:
                return 'u';
            default:
                break;
        }
        return 26;
    }
    public String rearrange(String S, int N){
        int[] consonants =  new int[26];
        int[] vowels = new int[5];
        Arrays.fill(vowels, 0);
        Arrays.fill(consonants, 0);
        int countConsonant = 0, vowelCount = 0;
        for(int i=0;i<N;i++){
            int pos = checkVowel(S.charAt(i));
            if(pos==-1){
                consonants[S.charAt(i)-'a']++;
                countConsonant++;
            }
            else{
                vowels[pos]++;
                vowelCount++;
            }
        }
        if(Math.abs(countConsonant - vowelCount) > 1){
            return "-1";
        }
        char[] result = S.toCharArray();
        int vowelIndex = 0, consonantIndex = 1, index = 0;
        boolean change = true;
        while(vowelIndex < 5 && vowels[vowelIndex]==0){
            vowelIndex++;
        }
        while(consonantIndex < 26 && consonants[consonantIndex]==0){
            consonantIndex++;
        }
        if(countConsonant > vowelCount || findVowel(vowelIndex) > consonantIndex + 'a'){
            change = false;
        }
        while(index < N){
            while(vowelIndex < 5 && vowels[vowelIndex]==0){
                vowelIndex++;
            }
            while(consonantIndex < 26 && consonants[consonantIndex]==0){
                consonantIndex++;
            }
            if(change){
                result[index] = findVowel(vowelIndex);
                vowels[vowelIndex]--;
            }
            else{
                result[index] = (char)(consonantIndex + 'a');
                consonants[consonantIndex]--;
            }
            change = !change;
            index++;
        }
        return String.valueOf(result);
    }
}