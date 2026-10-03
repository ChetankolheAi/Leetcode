class Solution {
    public int longestValidParentheses(String s) {
        StringBuilder sb = new StringBuilder();

        int CloseC = 0;
        int OpenC = 0;
        int MaxBracketCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                OpenC++;
            }
            else if(s.charAt(i)==')'){
                CloseC++;   
                
                
            }
            if(CloseC > OpenC){
                    CloseC = 0;
                    OpenC = 0;
                }
                if(OpenC==CloseC && CloseC!=0){
                    MaxBracketCount = Math.max(OpenC+CloseC , MaxBracketCount);
                }
        }
       OpenC = CloseC = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='('){
                OpenC++;
            }
            else if(s.charAt(i)==')'){
                CloseC++;   
            }
            if(CloseC < OpenC){
                CloseC = 0;
                OpenC = 0;
            }
            if(OpenC==CloseC ){
                MaxBracketCount = Math.max(OpenC+CloseC , MaxBracketCount);
            }
        }
       
        return MaxBracketCount;
    }
}