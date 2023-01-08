class Solution {
	static long countPairs(int n, int[] arr, int k) {
		// code here
		int[] rems = new int[k];
	    for(int i=0;i<k;i++){
	        rems[i] = 0;
	    }
	    for(int i=0;i<arr.length;i++){
	        rems[arr[i]%k] = rems[arr[i]%k] + 1;
	    }
	    long ans = 0;
	    for(int i=0;i<k;i++){
	        ans += (rems[i]*(rems[i]-1))/2;
	    }
	    return ans;
	}
}