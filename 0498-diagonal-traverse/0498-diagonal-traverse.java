class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        Map<Integer,List<Integer>>map = new HashMap<>();
        int row  = mat.length;
        int cols = mat[0].length;

        for(int i=0 ; i < row ; i++){
            for(int j=0 ; j < cols ; j++){
                
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
        int maxSize = (row-1)+(cols-1);
        int arr[] = new int[row*cols];
        int k = 0;
        for(int i=0;i<=maxSize;i++){
           
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