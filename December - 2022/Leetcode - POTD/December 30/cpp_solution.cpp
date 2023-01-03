class Solution {
    private List<List<Integer>> result;
    private void findPaths(int[][] graph, int x, boolean[] visited, List<Integer> res){
        int n = graph.length;
        res.add(x);
        if(x==n-1){
            this.result.add(new ArrayList<>(res));
            res.remove(res.size()-1);
            return;
        }
        visited[x] = true;
        for(int next : graph[x]){
            if(!visited[next]){
                findPaths(graph, next, visited, res);
            }
        }
        visited[x] = false;
        res.remove(res.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> temp = new ArrayList<Integer>();
        this.result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(visited, false);
        findPaths(graph, 0, visited, temp);
        return this.result;
    }
}