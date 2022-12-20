

//User function Template for Java


class Solution{
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE, minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            maxLeft = Math.max(maxLeft, arr[i]-i);
            maxRight = Math.max(maxRight, arr[i] + i);
            minLeft = Math.min(minLeft, arr[i] + i);
            minRight = Math.min(minRight, arr[i] - i);
        }
        return Math.max(maxLeft - minRight, maxRight - minLeft);
    }
    
}
