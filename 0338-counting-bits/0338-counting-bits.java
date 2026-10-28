class Solution {
    public int[] countBits(int n) {
        int arr[] = new int[n+1];
        for(int i=0;i<=n;i++){
            int count =0;
            int n1 = i;
            while(n1!=0){
                n1 = n1 & (n1-1);
                count++;
            }
            arr[i] = count;
        }
        return arr;
    }
}