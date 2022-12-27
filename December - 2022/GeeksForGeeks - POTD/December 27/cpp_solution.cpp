long long maxArea(long long A[], int len)
{
    // Your code goes here
    int low = 0, high = len - 1;
    long long ans = 0;
    while(low < high){
        ans = max(ans, min(A[low], A[high])*(high - low));
        if(A[low] < A[high]){
            low++;
        }
        else{
            high--;
        }
    }
    return ans;
}