class Info{
    public int dst, weight;
    Info(int dst, int w){
        this.dst = dst;
        this.weight = w;
    }
}

class Solution {
    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        ArrayList<Info> adj[] = new ArrayList[n+1];
        int[] dist = new int[n+1];
        for(int i=0;i<=n;i++){
            adj[i] = new ArrayList<Info>();
            dist[i] = -1;
        }
        for(int i=0;i<flights.length;i++){
            adj[flights[i][0]].add(new Info(flights[i][1], flights[i][2]));
        }
        // boolean[] visited =/ new boolean[n+1];
        // Arrays.fill(visited, false);
        dist[k] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        while(!queue.isEmpty()){
            int src = queue.poll();
            for(Info next : adj[src]){
                if(dist[next.dst]==-1 || dist[src] + next.weight < dist[next.dst]){
                    dist[next.dst] = dist[src] + next.weight;
                    queue.add(next.dst);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==-1){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}