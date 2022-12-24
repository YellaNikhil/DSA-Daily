class Solution{
  public:
  long long int wineSelling(vector<int>& arr, int N){
      //Code here.
      long long minTime = 0;
      vector<int> seller;
      for(int i=0;i<N;i++){
            if(arr[i] < 0){
                seller.emplace_back(i);
            }
        }
        int sellerIndex = 0, index = 0;
        while(sellerIndex < seller.size()){
            if(arr[index] <= 0){
                index++;
                continue;
            }
            int sellIndex = seller[sellerIndex];
            long long val = -1*arr[sellIndex];
            if(arr[index]==val){
                minTime += abs(sellIndex-index)*val;
                arr[sellIndex] = 0;
                index++;
                sellerIndex++;
            }
            else if(arr[index] > val){
                minTime += abs(sellIndex - index)*val;
                arr[sellIndex] = 0;
                sellerIndex++;
                arr[index] -= val;
            }
            else{
                minTime += abs(sellIndex - index)*(long long)arr[index];
                val -= arr[index];
                index++;
                arr[sellIndex] = (int)(-1*val);
            }
        }
        return minTime;
  }
};