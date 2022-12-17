class Solution {
    public:
    bool checkSign(string S){
        if(S.length() > 1){
            return false;
        }
        if(S[0]=='+' || S[0]=='-' || S[0]=='/' || S[0]=='*'){
            return true;
        }
        return false;
    }
    int evalRPN(vector<string> &tokens) {
        stack<int> st;
        for(int i=0;i<tokens.size();i++){
            if(checkSign(tokens[i])){
                char ch = tokens[i][0];
                long long int y = st.top();
                st.pop();
                loong long int x = st.top();
                st.pop();
                if(ch=='+'){
                    st.push(x + y);
                }
                else if(ch=='-'){
                    st.push(x - y);
                }
                else if(ch=='*'){
                    st.push(x*y);
                }
                else{
                    st.push(x/y);
                }
            }
            else{
                st.push(stoi(tokens[i]));
            }
        }
        return st.top();
    }
};