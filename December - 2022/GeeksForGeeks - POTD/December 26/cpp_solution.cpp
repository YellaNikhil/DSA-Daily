class Solution{
public:
    vector<long long> arr;
    void precompute()
    {
        // Code Here
        for(int i=2;i<63;i++){
            for(int j=1;j<i;j++){
                for(int k=0;k<j;k++){
                    long long num = (1LL<<i) | (1LL<<j) | (1LL<<k);
                    arr.emplace_back(num);
                }
            }
        }
    }
    
    long long solve(long long l, long long r){
        // Code Here
        long long left = lower_bound(arr.begin(),arr.end(), l) - arr.begin();
        long long right = lower_bound(arr.begin(), arr.end(), r) - arr.begin();
        if(arr[right]!=r){
            right--;
        }
        return right - left + 1;
    }
};
