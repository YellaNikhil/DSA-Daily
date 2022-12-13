
class Solution {
    static int accumulate(int[] arr){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];    
        }
        return sum;
    }
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int low = 0, high = accumulate(arr);
        int maxWindowSize = 0, result = 0;
        while(low <= high){
            int mid = (high - low)/2 + low;
            int sum = 0, count = 1;
            for(int i=0;i<N;i++){
                sum += arr[i];
                if(sum > mid){
                    count++;
                    sum = arr[i];
                }
            }
            if(count > K){
                low = mid + 1;
            }
            else{
                maxWindowSize = mid;
                high = mid - 1;
            }
        }
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += arr[i];
            if(sum > maxWindowSize){
                result = Math.max(result, sum - arr[i]);
                sum = arr[i];
            }
        }
        result = Math.max(result, sum);
        return result;
    }
};