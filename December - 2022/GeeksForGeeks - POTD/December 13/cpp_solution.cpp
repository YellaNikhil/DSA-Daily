class Solution {
  public:
    int splitArray(int arr[] ,int N, int K) {
        // code here
        int low = 0, high = accumulate(arr, arr+N, 0);
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
                result = max(result, sum - arr[i]);
                sum = arr[i];
            }
        }
        result = max(result, sum);
        return result;
    }
};