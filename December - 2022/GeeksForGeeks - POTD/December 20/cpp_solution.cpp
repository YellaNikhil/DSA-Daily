class Solution{
  public:
    int maxDistance(int arr[], int n){ 
        int maxLeft = INT_MIN, maxRight = INT_MIN, minLeft = INT_MAX, minRight = INT_MAX;
        for(int i=0;i<n;i++){
            maxLeft = max(maxLeft, arr[i] -i);
            maxRight = max(maxRight, arr[i] + i);
            minLeft = min(minLeft, arr[i] + i);
            minRight = min(minRight, arr[i]-i);
        }
        return max(maxLeft - minRight, maxRight - minLeft);
    } 
};