class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        if(strs.length==1){
            return 0;
        }
        for(int i=0;i<strs[0].length();i++){
            int j = 1;
            char prev = strs[j-1].charAt(i);
            while(j < strs.length){
                char pres = strs[j].charAt(i);
                if(pres < prev){
                    count++;
                    break;
                }
                prev = pres;
                j++;
            }
        }
        return count;
    }
}