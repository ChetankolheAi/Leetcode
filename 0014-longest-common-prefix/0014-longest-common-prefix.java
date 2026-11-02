class Solution {
    public String longestCommonPrefix(String[] strs) {
        String  s1 = strs[0];
        StringBuilder s = new StringBuilder(s1);
        for(int i=1;i<strs.length;i++){
            StringBuilder sb1 = new StringBuilder();
            for(int j=0;j<s.length() && j<strs[i].length();j++){
                if(s.charAt(j)==strs[i].charAt(j)){
                    sb1.append(s.charAt(j));
                }
                else{
                    break;
                }
            }
            System.out.println(sb1);
            s = sb1;
        }
        return s.toString();
    }
}