class Pair implements Comparable<Pair>{
    public int cap, filled;
    Pair(int cap, int filled){
        this.cap = cap;
        this.filled = filled;
    }
    public int compareTo(Pair s){
        int diff1 = this.cap - this.filled, diff2 = s.cap - s.filled;
        return diff1 - diff2;
    }
}
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<Pair> arr = new ArrayList<Pair>();
        int filled = 0;
        for(int i=0;i<capacity.length;i++){
            if(capacity[i]!=rocks[i]){
                arr.add(new Pair(capacity[i], rocks[i]));
            }
            else{
                filled++;
            }
        }
        if(arr.size()==0){
            return filled;
        }
        Collections.sort(arr);
        int index = 0;
        while(index < arr.size() && additionalRocks > 0){
            int diff = arr.get(index).cap - arr.get(index).filled;
            if(diff <= additionalRocks){
                filled++;
            }
            additionalRocks -= diff;
            index++;
        }
        return filled;
    }
}