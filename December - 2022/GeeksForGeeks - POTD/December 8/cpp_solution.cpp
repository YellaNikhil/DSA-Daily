class Solution
{
public:
    vector<int> threeDivisors(vector<long long> query, int q)
    {
        // Write your code here
        vector<int> result;
        long long int N = *max_element(query.begin(), query.end());
        int spf[N+1];
        memset(spf, 0, sizeof(spf));
        for(int i=1;i<=N;i++){
            // spf[i]++;
            for(int j=i;j<=N;j+=i){
                spf[j]++;
            }
        }
        int countDivisorsOfThree[N+1] = {0};
        memset(countDivisorsOfThree, 0, sizeof(countDivisorsOfThree));
        for(int i=1;i<=N;i++){
            if(spf[i]==3){
                countDivisorsOfThree[i] += countDivisorsOfThree[i-1] + 1;
            }
            else{
                countDivisorsOfThree[i] += countDivisorsOfThree[i-1];
            }
        }
        for(int i=0;i<query.size();i++){
            result.emplace_back(countDivisorsOfThree[query[i]]);
        }
        return result;
    }
};