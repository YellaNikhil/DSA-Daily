class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(map.containsKey(tasks[i])){
                map.put(tasks[i], map.get(tasks[i]) + 1);
            }
            else{
                map.put(tasks[i], 1);
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int x = entry.getValue();
            if(x==1){
                return -1;
            }
            if(x%3==0){
                count += x/3;
            }
            else{
                count += x/3 + 1;
            }
        }
        return count;
    }
}