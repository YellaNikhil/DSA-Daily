class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        priority_queue<int> maxHeap;
        for(auto num : piles){
            maxHeap.push(num);
        }
        while(k > 0 && !maxHeap.empty() && maxHeap.top()>1){
            int top = maxHeap.top();
            maxHeap.pop();
            top -= floor(top/2);
            maxHeap.push(top);
            k--;
        }
        int totalStones = 0;
        while(!maxHeap.empty()){
            totalStones += maxHeap.top();
            maxHeap.pop();
        }
        return totalStones;
    }
};