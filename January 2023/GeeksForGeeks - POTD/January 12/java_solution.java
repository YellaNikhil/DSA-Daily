//User function Template for Java

class Solution {
    long minimizeSum(int N, int arr[]) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int x : arr){
            minHeap.add(x);
        }
        int totalSum = 0;
        while(minHeap.size() > 1){
            int x = minHeap.poll();
            int y = minHeap.poll();
            totalSum += x + y;
            minHeap.add(x + y);
        }
        return totalSum;
    }
}