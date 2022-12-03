class Pair implements Comparable<Pair>{
    public int count;
    public char ch;
    Pair(int count, char ch){
        this.count = count;
        this.ch = ch;
    }
    public int compareTo(Pair p){
        return p.count - this.count;
    }
}

class Solution {
    public String frequencySort(String s) {
        int[] alphas = new int[256];
        Arrays.fill(alphas, 0);
        for(int i=0;i<s.length();i++){
            alphas[s.charAt(i)]++;
        }
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<256;i++){
            if(alphas[i] > 0){
                list.add(new Pair(alphas[i], (char)i));
            }
        }
        Collections.sort(list);
        char[] result = new char[s.length()];
        int index = 0;
        for(Pair p : list){
            while(p.count > 0){
                result[index++] = p.ch;
                p.count--;
            }
        }
        return String.valueOf(result);
    }
}