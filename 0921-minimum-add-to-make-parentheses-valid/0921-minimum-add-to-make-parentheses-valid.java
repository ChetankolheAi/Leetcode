class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character>st = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(st.isEmpty()) count++;
                else if(st.peek()=='(') st.pop();
            }
            else if(s.charAt(i)=='('){
                st.push('(');
            }
        }
        // while(!st.isEmpty()){
        //     count++;
        //     st.pop();
        // }
        // return count;

        return st.size()+count;
    }
}