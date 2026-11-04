class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int topRow = 0;
        int leftCol = 0;
        int bottomRow = row-1;
        int rightCol = col-1;

        int num = 1;
       
        List<Integer>ans =  new ArrayList<>();

        while(topRow <= bottomRow && leftCol <= rightCol )
        {
        
            for(int k = leftCol ; k <= rightCol ; k++)
            {
                ans.add(arr[topRow][k]);
                num++;
            }
            topRow++;
            for(int k = topRow ; k <= bottomRow ; k++ )
            {
                ans.add(arr[k][rightCol]);
                num++;
            }
            rightCol--;
            if(topRow <= bottomRow && leftCol <= rightCol)
            {
                for(int k = rightCol ; k >= leftCol ; k-- )
                {
                    ans.add(arr[bottomRow][k]);
                    num++;
                }
                bottomRow--;
    
                for(int k = bottomRow ; k >= topRow ; k-- )
                {
                    ans.add(arr[k][leftCol]);
                    num++;
                }
                leftCol++;
            }
        }
        return ans;
    }
}