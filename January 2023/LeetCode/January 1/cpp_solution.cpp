class Solution {
public:
    bool wordPattern(string pattern, string s) {
        map<char, string> m;
        set<string> dup;
        istringstream  ss(s);
        int i = 0;
        string word;
        vector<string> words;
        while(ss >> word){
            words.emplace_back(word);
        }
        if(words.size()!=pattern.size()){
            return false;
        }
        while(i < pattern.length()){
            if(m.find(pattern[i])!=m.end()){
                if(m[pattern[i]]!=words[i]){
                    return false;
                }
            }
            else{
                if(dup.find(words[i])!=dup.end()){
                    return false;
                }
                dup.insert(words[i]);
                m[pattern[i]] = words[i];
            }
            i++;
        }
        return true;
    }
};