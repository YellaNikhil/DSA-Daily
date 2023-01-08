class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n==1){
            return n;
        }
        int result = 2;
        for(int i=0;i<n-1;i++){
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int samepoints = 0;
            for(int j=i+1;j<n;j++){
                double numerator = points[j][1] - points[i][1];
                double denominator = points[j][0] - points[i][0];
                if(numerator==0 && denominator==0){
                    samepoints++;
                    continue;
                }
                if(denominator==0){
                    if(map.containsKey(Double.POSITIVE_INFINITY)){
                        map.put(Double.POSITIVE_INFINITY, map.get(Double.POSITIVE_INFINITY) + 1);
                    }
                    else{
                        map.put(Double.POSITIVE_INFINITY, 1);
                    }
                }
                else if(numerator==0){
                    if(map.containsKey(0.0)){
                        map.put(0.0, map.get(0.0) + 1);
                    }
                    else{
                        map.put(0.0, 1);
                    }
                }
                else{
                    if(map.containsKey(numerator/denominator)){
                        map.put(numerator/denominator, map.get(numerator/denominator) + 1);
                    }
                    else{
                        map.put(numerator/denominator, 1);
                    }
                }
            }
            for(Map.Entry<Double,Integer> mapElement : map.entrySet()){
                System.out.println(mapElement.getValue());
                result = Math.max(result, mapElement.getValue() + samepoints + 1);
            }
        }
        return result;
    }
}