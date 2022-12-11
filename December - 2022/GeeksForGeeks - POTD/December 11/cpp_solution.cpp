class Solution {
  public:
    bool canPair(vector<int> nums, int k) {
        // Code here.
        if(nums.size()%2==1){
            return false;
        }
        if(k==1){
            return true;
        }
        int nLength = nums.size();
        int rems[k];
        memset(rems, 0, sizeof(rems));
        for(int i=0;i<nLength;i++){
            rems[nums[i]%k]++;
        }
        if(k%2==0 && rems[k/2]%2==1){
            return false;
        }
        int i = 1;
        k--;
        while(i < k){
            if(rems[i]!=rems[k]){
                return false;
            }
            i++;
            k--;
        }
        return rems[0]%2==0;
    }
};