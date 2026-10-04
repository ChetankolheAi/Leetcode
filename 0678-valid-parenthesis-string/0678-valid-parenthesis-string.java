// class Solution {
//     Boolean checkIsValid(String s){
//         Stack<Character>st= new Stack<>();

//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='('){
//                 st.push(s.charAt(i));
//             }
//             else if(s.charAt(i)==')'){
//                 if(st.isEmpty())return false;
//                 if(st.peek()=='('){
//                     st.pop();
//                 }
//             }
             
//         }
//         if(st.isEmpty()) return true;
//         return false;
//     }

//     Boolean FindStrings(String s , int i){
//         if(i==s.length()) {
//             return checkIsValid(s);  
//         }
        
//         if(s.charAt(i)=='*'){
//             StringBuilder sb = new StringBuilder(s);
//             sb.setCharAt(i, '(');
//             s = sb.toString();

//             Boolean One = FindStrings(s,i+1);

//             StringBuilder sb1 = new StringBuilder(s);
//             sb1.setCharAt(i, ')');
//             s = sb1.toString();

//             Boolean Two = FindStrings(s,i+1);

//             StringBuilder sb2 = new StringBuilder(s);
//             sb2.setCharAt(i, ' ');
//             s = sb2.toString();
            

//             Boolean Three = FindStrings(s,i+1);

//             return One || Two || Three;

//         }
//         return FindStrings(s, i + 1);
//     }
//     public boolean checkValidString(String s) {
       
//        return FindStrings(s,0);

//     }
// }



class Solution {

    Boolean[][] dp;

    Boolean FindStrings(String s, int i, int open) {

        // Too many closing brackets
        if (open < 0) {
            return false;
        }

        // End of string
        if (i == s.length()) {
            return open == 0;
        }

        if (dp[i][open] != null) {
            return dp[i][open];
        }
        char ch = s.charAt(i);

        boolean ans;        
         if (ch == '(') {
            ans = FindStrings(s, i + 1, open + 1);
        }
        else if (ch == ')') {
            ans = FindStrings(s, i + 1, open - 1);
        }
        else {
            ans = FindStrings(s, i + 1, open + 1) 
                 || FindStrings(s, i + 1, open - 1)
                 || FindStrings(s, i + 1, open);     
        }

        return dp[i][open] = ans;
    }

    public boolean checkValidString(String s) {
        dp = new Boolean[s.length()][s.length() + 1];
        return FindStrings(s, 0, 0);
    }
}