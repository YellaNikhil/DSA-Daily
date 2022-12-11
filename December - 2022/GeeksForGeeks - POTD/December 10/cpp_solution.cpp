string buildLowestNumber(string num, int k)
{
    stack<char> st;
    for(int i=0;i<num.length();i++){
        while(!st.empty() && k > 0 && st.top() > num[i]){
            st.pop();
            k--;
        }
        if(num[i]=='0' && st.empty()){
            continue;
        }
        st.push(num[i]);
    }
    while(st.empty()==false && k > 0){
        st.pop();
        k--;
    }
    if(st.empty()){
        return "0";
    }
    string res = "";
    while(!st.empty()){
        res.push_back(st.top());
        st.pop();
    }
    reverse(res.begin(), res.end());
    return res;
}