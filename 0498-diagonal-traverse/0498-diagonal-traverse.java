class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer,List<Integer>>map = new HashMap<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(!map.containsKey(i+j)){
                    List<Integer>li = new ArrayList<>();
                    li.add(mat[i][j]);
                    map.put(i+j , li);
                }
                else{
                   map.get(i + j).add(mat[i][j]);
                }
            }
        }
        int maxSize = (mat.length-1)+(mat[0].length-1);
        int arr[] = new int[mat.length*mat[0].length];
        int k = 0;
        for(int i=0;i<=maxSize;i++){
            System.out.println(map.get(i));
            if(i%2!=0){
                for(int j = 0;j<map.get(i).size();j++){
                    arr[k] = map.get(i).get(j);
                    k++;
                }
            }
            if(i%2==0){
                for(int j = map.get(i).size()-1;j>=0 ;j--){
                    arr[k] = map.get(i).get(j);
                    k++;
                }
            }
        }
        return arr;
        
    }
}