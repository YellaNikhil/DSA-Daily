class Solution {
    private void findLabels(List<Integer>[] adj, char[] nodeLabels,int[][] countLabels, int node, boolean[] visited){
        visited[node] = true;
        countLabels[node][nodeLabels[node]-'a'] = 1;
        for(Integer next : adj[node]){
            if(!visited[next]){
                findLabels(adj, nodeLabels, countLabels, next, visited);
                for(int i=0;i<26;i++){
                    countLabels[node][i] += countLabels[next][i];
                }
            }
        }
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[][] countLabels = new int[n][26];
        List<Integer>[] adj = new ArrayList[n];
        char[] nodeLabels = labels.toCharArray();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<Integer>();
            Arrays.fill(countLabels[i], 0);
        }
        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        findLabels(adj, nodeLabels, countLabels, 0, visited);
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int ch = nodeLabels[i] - 'a';
            result[i] = countLabels[i][ch];
        }
        return result;
    }
}