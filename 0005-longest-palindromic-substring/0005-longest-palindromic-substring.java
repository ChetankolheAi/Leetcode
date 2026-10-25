class Solution {
    public boolean checkIsPalindrome(String s, int start , int end){
       while(start<end){
        if(s.charAt(start)!=s.charAt(end)){
            return false;
        }
        start++;
        end--;
       }
        return true;
    }
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int maxJ = 0;
        int maxI = 0;
        for(int i=0;i<s.length();i++){
           
            for(int j=i;j<s.length();j++){
                
                if(checkIsPalindrome(s,i,j)){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        maxI = i;
                        maxJ = j;
                    }
                }
                
            }
        }
        StringBuilder sb = new StringBuilder();
        while(maxI<=maxJ){
            sb.append(s.charAt(maxI));
            maxI++;
        }
        return sb.toString();
    }
}