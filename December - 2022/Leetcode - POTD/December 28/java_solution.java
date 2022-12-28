class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalStones = 0;
        for(int i=0;i<piles.length;i++){
            maxHeap.add(piles[i]);
        }
        while(k > 0 && maxHeap.isEmpty()==false && maxHeap.peek()>1){
            int top = maxHeap.poll();
            top -= Math.floor(top/2);
            maxHeap.add(top);
            k--;
        }
        while(!maxHeap.isEmpty()){
            totalStones += maxHeap.poll();
        }
        return totalStones;
    }
}