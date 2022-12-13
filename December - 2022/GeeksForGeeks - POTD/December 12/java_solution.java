class Solution {
    static int timer = 0;
  public void solve(int node,ArrayList<Integer> dis,ArrayList<Integer> low,ArrayList<Boolean> vis,int par,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> art){
        vis.set(node,true);
        timer++;
        dis.set(node, timer);
        low.set(node,timer);
        int child=0;
        for(int i=0;i<adj.get(node).size();i++){
            int x = adj.get(node).get(i);
            if(x==par) 
                continue;

            if(vis.get(x)==false){
              solve(x,dis,low,vis,node,adj,art);
              low.set(node, Math.min(low.get(node),low.get(x)));
              if(low.get(x)>=dis.get(node) && par!=-1){
                  art.set(node, 1);
              }
            child++;
            }
            else{
                low.set(node, Math.min(low.get(node),dis.get(x)));
            }
        }
        if(par==-1 && child>1){
          art.set(node, 1);
        }    
    }
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> dis = new ArrayList<>(V);
        ArrayList<Integer> low = new ArrayList<>(V);
        ArrayList<Boolean> vis = new ArrayList<>(V);
        ArrayList<Integer> art = new ArrayList<>(V);
        for(int i=0;i<V;i++){
            art.set(i, 0);
            vis.set(i, false);
            low.set(i, -1);
            dis.set(i, -1);
        }
        solve(0,dis,low,vis,-1,adj,art);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(art.get(i)==1){
                ans.add(i);
            }
        }
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
}