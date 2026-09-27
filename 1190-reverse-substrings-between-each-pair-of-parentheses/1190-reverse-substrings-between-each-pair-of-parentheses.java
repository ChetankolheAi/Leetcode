class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>st= new Stack<>();

        StringBuilder sbAns = new StringBuilder();
      
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==')'){

                StringBuilder sb = new StringBuilder();

                while(st.peek()!='('){

                    sb.append(st.peek());
                    st.pop();

                }
                
                String temp1 = sb.toString();

                st.pop();

               
                for(int j=0;j<temp1.length();j++){

                    st.push(temp1.charAt(j));

                }

            }
            else{

                st.push(s.charAt(i));

            }
        }

        while(!st.isEmpty()){

            sbAns.append(st.peek());
            st.pop();

        }
        sbAns.reverse();
        String ans = sbAns.toString();
        return ans;
    }
}