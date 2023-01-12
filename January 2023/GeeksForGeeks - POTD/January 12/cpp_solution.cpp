//User function Template for C++

class Solution {
public:
    int minimizeSum(int N, vector<int> arr) {
        // code here
        priority_queue<int, vector<int>, greater<int>> minHeap(arr.begin(), arr.end());
        int totalSum = 0;
        while(minHeap.size() > 1){
            int x = minHeap.top();
            minHeap.pop();
            int y = minHeap.top();
            minHeap.pop();
            int sum = x + y;
            totalSum += sum;
            minHeap.push(sum);
        }
        minHeap.pop();
        return totalSum;
    }
};