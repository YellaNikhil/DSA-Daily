class Solution{
    public:
    //Function to count subarrays with sum equal to 0.
    long long findSubarray(vector<long long> arr, int n ) {
        //code here
        long long count = 0, sum = 0;
        map<long long, int> m;
        int i = 0;
        m[0] = 1;
        while(i<n){
            sum+=arr[i];
            if(m.find(sum)!=m.end()){
                count += m[sum];
            }
            m[sum]++;
            i++;
        }
        return count;
    }
};