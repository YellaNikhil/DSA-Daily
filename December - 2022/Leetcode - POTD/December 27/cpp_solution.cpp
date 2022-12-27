class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        vector<int> arr;
        int filled = 0;
        for(int i=0;i<capacity.size();i++){
            if(capacity[i]==rocks[i]){
                filled++;
            }
            else{
                arr.push_back(capacity[i]-rocks[i]);
            }
        }
        if(arr.size()==0){
            return filled;
        }
        sort(arr.begin(), arr.end());
        int index = 0;
        while(index < arr.size() && additionalRocks > 0){
            if(arr[index] <= additionalRocks){
                filled++;
            }
            additionalRocks -= arr[index];
            index++;
        }
        return filled;
    }
};