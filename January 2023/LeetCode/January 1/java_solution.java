class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> duplicates = new HashSet<String>();
        if(pattern.length()!=words.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch).equals(words[i])==false){
                    return false;
                }
            }
            else{
                if(duplicates.contains(words[i])){
                    return false;
                }
                map.put(ch, words[i]);
                duplicates.add(words[i]);
            }
        }
        return true;
    }
}