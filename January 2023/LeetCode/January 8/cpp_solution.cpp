class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        if(points.size()==1){
            return 1;
        }
        int result = 1;
        double inf = std::numeric_limits<double>::infinity();
        for(int i=0;i<points.size()-1;i++){
            unordered_map<double, int> slopes;
            int samePoints = 0;
            for(int j=i+1;j<points.size();j++){
                double numerator = points[j][1] - points[i][1];
                double denominator = points[j][0] - points[i][0];
                if(numerator==0 && denominator==0){
                    samePoints++;
                    continue;
                }
                if(denominator==0){
                    slopes[inf]++;
                }
                else{
                    slopes[numerator/denominator]++;
                }
            }
            for(auto ele : slopes){
                result = max(result, ele.second + samePoints + 1);
            }
        }
        return result;
    }
};