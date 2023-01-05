class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return 0;
                }
                else if(a[0] > b[0]){
                    return 1;
                }
                return -1;
            }
        });
        int end = points[0][1];
        int arrows = 1;
        for(int i=1;i<points.length;i++){
            if(end >= points[i][0]){
                end = Math.min(end, points[i][1]);
            }
            else{
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}