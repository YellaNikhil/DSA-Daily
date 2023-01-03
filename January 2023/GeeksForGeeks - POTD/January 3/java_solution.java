

//User function Template for Java

class Solution {
    private int findIndex(int[] nums, int low, int high, int val){
        while(low <= high){
            int mid = (high - low)/2 + low;
            if(nums[mid] < val){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public int removeStudents(int[] H, int N) {
        // code here
        int[] nums = new int[N];
        nums[0] = H[0];
        int ans = 1;
        for(int i=1;i<H.length;i++){
            int index = findIndex(nums, 0, ans-1, H[i]);
            nums[index] = H[i];
            ans = Math.max(index + 1, ans);
        }
        return N - ans;
    }
};