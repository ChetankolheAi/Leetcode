class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                st.push(s.charAt(i));
            }
            if(s.charAt(i)==')'){
                    System.out.println("Here");
                if(st.isEmpty()){
                    return false;
                }
                if(st.peek()!='('){
                    System.out.println("Here");
                    return false;
                }
                else{
                    st.pop();
                } 
            }
            else if(s.charAt(i)==']'){
                if(st.isEmpty()){
                    return false;
                }
                if(st.peek()!='['){
                    return false;
                }
                else{
                    st.pop();
                }    
            }
            else if(s.charAt(i)=='}'){
                if(st.isEmpty()){
                    return false;
                }
                if(st.peek()!='{'){
                    return false;
                }
                else{
                    st.pop();
                }   
            }

            if(!st.isEmpty()){
                System.out.println(st.peek());
            }
        }
        if(st.isEmpty()){
            System.out.println("Here");
            return true;
        }
        return false;
    }
}