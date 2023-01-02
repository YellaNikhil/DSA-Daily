class Solution {
  public:
    vector<int> asteroidCollision(int N, vector<int> &asteroids) {
        // code here
        stack<int> st;
        for(int i=0;i<asteroids.size();i++){
            if(st.empty()){
                st.push(i);
                continue;
            }
            int value = abs(asteroids[i]);
            if(asteroids[i] < 0 && asteroids[st.top()] > 0){
                while(st.empty()==false && asteroids[st.top()] > 0 && value > asteroids[st.top()]){
                    st.pop();
                }
                if(st.empty()==false){
                    if(asteroids[st.top()]==value){
                        st.pop();
                    }
                    else if(asteroids[st.top()] < 0){
                        st.push(i);
                    }
                }
                else{
                    st.push(i);
                }
            }
            else{
                st.push(i);
            }
        }
        vector<int> result;
        while(st.empty()==false){
            result.emplace_back(asteroids[st.top()]);
            st.pop();
        }
        reverse(result.begin(), result.end());
        return result;
    }
};