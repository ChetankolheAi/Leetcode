class Solution {
    public String reverseString(String s , int i  , int j){
        StringBuilder sb = new StringBuilder(s);
        while(i<j){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }
        return sb.toString();
    }
    public String reverseStr(String s, int k) {
        if(k>s.length()) k=s.length();
        int m = 0;
        int revIndex =  m+k-1;
        while(revIndex <= s.length()){
           
                s = reverseString(s,m,revIndex);
            
            m +=  k*2;
            revIndex =  m+k-1;
          
        }
        if(revIndex > s.length()){
            revIndex = s.length()-1;
        }
        s = reverseString(s,m,revIndex);
        return s;

    }
}