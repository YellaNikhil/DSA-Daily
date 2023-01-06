class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        while(coins >= 0 && i < costs.length && costs[i] <= coins){
            coins -= costs[i++];
        }
        return i;
    }
}