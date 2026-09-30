class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int CrrDepth = 0;
        int ans[] = new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            int temp = 0;
            if(seq.charAt(i)=='('){
                CrrDepth++;
            }
            else if(seq.charAt(i)==')')
            {   
                temp = CrrDepth;
                CrrDepth--;
            }
            temp = Math.max(CrrDepth , temp);
            if(temp%2==0) ans[i] = 1;
            else ans[i] = 0;
        }
        return ans;
         
           
    }
}