class Solution {
    public boolean canPair(int[] nums, int k) {
        if(nums.length%2==1){
            return false;
        }
        if(k==1){
            return true;
        }
        int nLength = nums.length;
        int[] rems = new int[k];
        Arrays.fill(rems, 0);
        for(int i=0;i<nums.length;i++){
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
}