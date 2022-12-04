class Solution{
    public:
    int checkVowel(char C){
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
    char findVowel(int index){
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
    string rearrange (string S, int N)
    {
        // your code here
        int consonants[26] =  {0};
        int vowels[5] = {0};
        int countConsonant = 0, vowelCount = 0;
        for(int i=0;i<N;i++){
            int pos = checkVowel(S[i]);
            if(pos==-1){
                consonants[S[i]-'a']++;
                countConsonant++;
            }
            else{
                vowels[pos]++;
                vowelCount++;
            }
        }
        if(abs(countConsonant - vowelCount) > 1){
            return "-1";
        }
        int vowelIndex = 0, consonantIndex = 1, index = 0;
        bool change = true;
        if(countConsonant > vowelCount){
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
                S[index] = findVowel(vowelIndex);
                vowels[vowelIndex]--;
            }
            else{
                S[index] = consonantIndex+'a';
                consonants[consonantIndex]--;
            }
            change = !change;
            index++;
        }
        return S;
    }
}