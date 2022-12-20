class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[rooms.size()];
        Arrays.fill(visited, false);
        queue.add(0);
        while(!queue.isEmpty()){
            int room = queue.poll();
            visited[room] = true;
            for(Integer key : rooms.get(room)){
                if(!visited[key]){
                    queue.add(key);
                }
            }
        }
        for(int i=0;i<rooms.size();i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}