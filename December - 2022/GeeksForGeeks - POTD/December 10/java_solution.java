class Solution {
    static String buildLowestNumber(String str, int N) {
        char[] num = str.toCharArray();
        Stack<Character> st = new Stack<>();
    for(int i=0;i<num.length;i++){
        while(!st.isEmpty() && N > 0 && st.peek() > num[i]){
            st.pop();
            N--;
        }
        if(num[i]=='0' && st.isEmpty()){
            continue;
        }
        st.push(num[i]);
    }
    while(st.isEmpty()==false && N > 0){
        st.pop();
        N--;
    }
    if(st.isEmpty()){
        return "0";
    }
    char[] res = new char[st.size()];
    while(!st.empty()){
        res[st.size()-1] = st.pop();
    }
    str = String.valueOf(res);
    return str;
    }
}