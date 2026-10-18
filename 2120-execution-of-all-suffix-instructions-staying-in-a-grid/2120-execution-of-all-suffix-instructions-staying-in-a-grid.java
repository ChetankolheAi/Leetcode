class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
    
        int ans[] = new int[s.length()];

        
        for(int i=0;i<s.length();i++){
            int starti = startPos[0];
            int startj = startPos[1];
            int dirIndex = i;

            // System.out.println(dirIndex);
            //System.out.println(starti+","+startj);
            int count = 0;
            while(starti>=0 && startj>=0 && starti < n && startj < n && dirIndex < s.length()){
                char ch = s.charAt(dirIndex);
                
                if(ch=='R') startj++;
                else if(ch=='U') starti--;
                else if(ch=='D') starti++;
                else if(ch=='L') startj--;
                //System.out.println(ch+","+starti+","+startj);

                if(starti < 0 || starti >= n || startj < 0 || startj >= n){
                    ans[i] = count;
                    break;
                }
                count++;
                dirIndex++;
            }
            ans[i] = count;
            //System.out.println("==========================");
        }
        return ans;

    }
}