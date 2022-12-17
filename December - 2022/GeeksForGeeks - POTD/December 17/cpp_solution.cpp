#define MOD 1000000007

class Solution{   
public:
    int waysToBreakNumber(int N){
        // code here
        long long int result = ((long long)N*3);
        result += (((long long)N-1)*((long long)N-2))/2;
        result = result%MOD;
        return result;
    }
};
