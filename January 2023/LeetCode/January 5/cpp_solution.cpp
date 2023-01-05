bool compare(vector<int> &first, vector<int> &second){
    return first[0] < second[0];
}
class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end(), compare);
        int end = points[0][1];
        int arrows = 1;
        for(int i=1;i<points.size();i++){
            if(end >= points[i][0]){
                end = min(points[i][1], end);
            }
            else{
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
};