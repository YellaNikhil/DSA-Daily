class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        ArrayList<Integer> result = new ArrayList<>();;
        int N = Collections.max(query).intValue();
        int[] spf = new int[N+1];
        int[] counts = new int[N+1];
        Arrays.fill(counts, 0);
        Arrays.fill(spf, 0);
        for(int i=1;i<=N;i++){
            for(int j=i;j<=N;j+=i){
                spf[j]++;
            }
        }
        for(int i=1;i<=N;i++){
            if(spf[i]==3){
                counts[i]++;
            }
            counts[i]+=counts[i-1];
        }
        for(int i=0;i<query.size();i++){
            result.add(counts[query.get(i).intValue()]);
        }
        return result;
    }
}