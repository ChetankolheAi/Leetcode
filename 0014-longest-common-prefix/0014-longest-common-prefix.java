class Solution {
    public String longestCommonPrefix(String[] strs) {
   
        StringBuilder s = new StringBuilder(strs[0]);
        for(int i=1;i<strs.length;i++){
            StringBuilder sb1 = new StringBuilder();
            for(int j=0;j<s.length() && j<strs[i].length();j++){
                if(s.charAt(j)==strs[i].charAt(j)) sb1.append(s.charAt(j));
                else break;
            }
            s = sb1;
        }
        return s.toString();
    }
}