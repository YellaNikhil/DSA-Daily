class Solution {
  public:
    long long countPairs(int n, int arr[], int k) {
        // code here
        vector<int> rems(k, 0);
        for(int i=0;i<n;i++){
            rems[arr[i]%k]++;
        }
        long long ans = 0;
        for(int i=0;i<k;i++){
            ans += (rems[i]*(rems[i]-1))/2;
        }
        return ans;
    }
};