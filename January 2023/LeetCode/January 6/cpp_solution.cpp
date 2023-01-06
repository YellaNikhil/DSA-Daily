class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(costs.begin(), costs.end());
        int count = 0;
        while(coins > 0 && count < costs.size() && costs[count] <= coins){
            coins -= costs[count];
            count++;
        }
        return count;
    }
};