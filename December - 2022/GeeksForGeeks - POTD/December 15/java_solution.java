class Solve {
    Vector<Integer> findRange(String str, int n) {
        // code here
        Vector<Integer> res = new Vector<Integer>();
        int start = -1, end = -1, oneSum = 0, sumSoFar = 0, newStart = 0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='0'){
                oneSum++;
            }
            else{
                oneSum--;
            }
            if(oneSum > sumSoFar){
                sumSoFar = oneSum;
                start = newStart;
                end = i;
            }
            else if(oneSum < 0){
                newStart = i+1;
                oneSum = 0;
            }
        }
        if(end==-1){
            res.add(-1);
            return res;
        }
        res.add(start+1);
        res.add(end+1);
        return res;
    }
}