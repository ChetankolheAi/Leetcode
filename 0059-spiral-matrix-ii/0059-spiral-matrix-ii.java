class Solution {
    public int[][] generateMatrix(int n) {
        int topRow = 0;
        int bottomRow = n-1;
        int leftCol = 0;
        int rightCol = n-1;
        int num = 1;
        int arr[][] = new int[n][n];
        while(topRow <= bottomRow && leftCol <= rightCol ){
            for(int k = leftCol ; k <= rightCol ; k++){
                arr[topRow][k] = num;
                num++;
            }
            topRow++;
            for(int k = topRow ; k <= bottomRow ; k++ ){
                arr[k][rightCol] = num;
                num++;
            }
            rightCol--;
            for(int k = rightCol ; k >= leftCol ; k-- ){
                arr[bottomRow][k] = num;
                num++;
            }
            bottomRow--;
             for(int k = bottomRow ; k >= topRow ; k-- ){
                arr[k][leftCol] = num;
                num++;
            }
            leftCol++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }
        return arr;
    }
}