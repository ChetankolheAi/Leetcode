class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("/") && !tokens[i].equals("*") && !tokens[i].equals("+") && !tokens[i].equals("-")){
                st.push(Integer.parseInt(tokens[i]));
            }
            else{
                int num1 = st.peek();
                st.pop();
                if(st.isEmpty()) return num1;
                int num2 =st.peek();
                st.pop();
                System.out.println(num1+","+num2);
                if(tokens[i].charAt(0)=='+'){
                    int ans = num2+num1;
                    st.push(ans);
                    
                }
                else if(tokens[i].charAt(0)=='-'){
                    int ans = num2-num1;
                    st.push(ans);
                }
                else if(tokens[i].charAt(0)=='*'){
                    int ans = num2*num1;
                    st.push(ans);
                }
                else if(tokens[i].charAt(0)=='/'){
                    int ans = num2/num1;
                    st.push(ans);
                }
            }
        }
        return st.peek();
    }
}