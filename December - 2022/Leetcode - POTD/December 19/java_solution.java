class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        while(!queue.isEmpty()){
            source = queue.poll();
            if(source==destination){
                return true;
            }
            visited[source] = true;
            for(Integer next : adj[source]){
                if(!visited[next]){
                    queue.add(next);
                }
            }
        }
        return false;
    }
}