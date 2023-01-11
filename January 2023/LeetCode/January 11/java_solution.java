class Info{
    public int dir;
    public boolean apple;
    Info(int dir, boolean apple){
        this.dir = dir;
        this.apple = apple;
    }
}
class Solution {
    public void findTime(ArrayList<Integer>[] adj, List<Boolean> hasApples, int node, Info info, boolean[] visited){
        boolean found = false;
        visited[node] = true;
        if(hasApples.get(node)==true){
            found = true;
        }
        info.apple = found;
        for(int x : adj[node]){
            if(visited[x]!=true){
                Info left = new Info(0, false);
                findTime(adj, hasApples, x, left, visited);
                if(left.apple){
                    info.dir += left.dir + 1;
                    info.apple = true;
                }
            }
        }
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<Integer>();
        }
        Info result = new Info(0, false);
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        findTime(adj, hasApple, 0, result, visited);
        return result.dir*2;
    }
}