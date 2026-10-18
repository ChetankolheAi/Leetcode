class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int ans[] = new int[s.length()];
        
        for(int k=0 ; k < s.length() ; k++){
            
            int i = startPos[0];
            int j = startPos[1];

            int dirIndex = k;
            int count = 0;

            while(i>=0 && j>=0 && i < n && j < n && dirIndex < s.length()){

                char ch = s.charAt(dirIndex);
                
                if(ch =='R') j++;
                else if(ch =='U') i--;
                else if(ch =='D') i++;
                else if(ch =='L') j--;
               
                if( i < 0 || i >= n || j < 0 || j >= n){
                    ans[k] = count;
                    break;
                }
                count++;
                dirIndex++;

            }
            ans[k] = count;

        }
        return ans;

    }
}