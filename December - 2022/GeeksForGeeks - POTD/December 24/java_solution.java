class Solution {
    long wineSelling(int arr[],int N){
        // code here
        long time = 0;
        ArrayList<Integer> seller = new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            if(arr[i] < 0){
                seller.add(i);
            }
        }
        int sellerIndex = 0, index = 0;
        while(sellerIndex < seller.size()){
            if(arr[index] <= 0){
                index++;
                continue;
            }
            int sellIndex = seller.get(sellerIndex);
            long val = -1*arr[sellIndex];
            if(arr[index]==val){
                time += Math.abs(sellIndex-index)*val;
                arr[sellIndex] = 0;
                index++;
                sellerIndex++;
            }
            else if(arr[index] > val){
                time += Math.abs(sellIndex - index)*val;
                arr[sellIndex] = 0;
                sellerIndex++;
                arr[index] -= val;
            }
            else{
                time += Math.abs(sellIndex - index)*(long)arr[index];
                val -= arr[index];
                index++;
                arr[sellIndex] = (int)(-1*val);
            }
            // System.out.println(time);
        }
        return time;
    }
}