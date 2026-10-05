class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<String>st = new Stack<>();
        for(int i=0;i<s.length();i++){
           
            if(s.charAt(i)=='('){
                st.push("(");
            }
            else if(s.charAt(i)==')'){
                int tempSum = 0;
                if(st.peek()=="("){
                    st.pop();
                    st.push("1");
                }
                else{
                    while(st.peek()!="("){
                        tempSum += Integer.parseInt(st.peek());
                        st.pop();
                    }
                    st.pop();
                    int ss= tempSum*2;
                    String ch = String.valueOf(ss);
                    st.push(ch);
                }
                
                
            }
            
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum+= Integer.parseInt(st.peek());
            st.pop();
        }
        return sum;

    }
}