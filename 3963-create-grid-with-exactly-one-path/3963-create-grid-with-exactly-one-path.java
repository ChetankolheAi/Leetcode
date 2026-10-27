class Solution {
    public String[] createGrid(int m, int n) {
        String[]  ans = new String[m];
        
        // for(int i=0;i<m;i++){
        //     StringBuilder sb = new StringBuilder();
        //     for(int j=0;j<n;j++){
        //         if(i==0 || j == n-1){
        //             sb.append('.');
        //         }
        //         else{
        //             sb.append('#');
        //         }
        //     }
        //     ans[i] = sb.toString();
        // }
        // return ans;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append('.');
        }
        ans[0] = sb.toString();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==n-1) sb1.append('.');
            else sb1.append('#');
        }
        for(int i=1;i<m;i++){
            ans[i] = sb1.toString();
        }
        return ans;
        
    }

}