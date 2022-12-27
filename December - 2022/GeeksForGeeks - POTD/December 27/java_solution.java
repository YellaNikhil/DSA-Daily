
class Solve{
    
    long maxArea(int A[], int len){
        // Code Here
        if(len==1){
            return 0;
        }
        int low = 0, high = len - 1;
        long ans = 0;
        while(low < high){
            ans = Math.max(ans, (long)(high - low)*(long)Math.min(A[low], A[high]));
            if(A[low] < A[high]){
                low++;
            }
            else{
                high--;
            }
        }
        return ans;
    }
    
}