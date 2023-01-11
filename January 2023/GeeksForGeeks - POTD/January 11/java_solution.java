class Solution {
    public long minIncrements(int[] arr, int N) {
        // Code here
        Arrays.sort(arr);
        int prev = -1, index = 0, n = arr.length, prevValue = 0;
        long result = 0;
        while(index < n){
            int presVal = arr[index];
            int pres = index;
            while(index < n && presVal == arr[index]){
                index++;
            }
            long count = index - pres, diff = 0;
            if(prev!=-1 && presVal <= prevValue){
                diff = prevValue - presVal + 1;
            }
            result = result + (count*(count-1))/2 + diff*count;
            prev = index - 1;
            prevValue = arr[index-1] + (int)count - 1 + (int)diff;
        }
        return result;
    }
}