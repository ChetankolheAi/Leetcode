class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int closeNeeded = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(closeNeeded%2!=0){
                    count++;
                    closeNeeded--;
                }
                closeNeeded+=2;
            }
            else if(s.charAt(i)==')'){
                closeNeeded--;
                if(closeNeeded<0){
                    count++;
                    closeNeeded+=2;
                }

            }
           
            
        }
       

        return count+closeNeeded;
        
    }
}



// int count = 0;
//         Stack<Character> st = new Stack<>();
//         boolean isFirstClosingFound = false;
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='('){
//                 st.push('(');

//                 if(isFirstClosingFound){
//                     if(!st.isEmpty()){
//                         count++;
//                         st.pop();
//                     }
//                     else if(st.isEmpty()){
//                         count+=2;
//                     }
//                     isFirstClosingFound = false;
//                 }
//                 // System.out.println("Here___"+count);

//             }
//             else if(s.charAt(i)==')' && !isFirstClosingFound){
//                 isFirstClosingFound = true;
//                 // System.out.println("else if 1___"+count);
//             }
//             else if(s.charAt(i)==')'&& isFirstClosingFound){
//                 if(st.isEmpty()){
//                     count++;
//                     // System.out.println("Here else if 2____"+count);
//                     isFirstClosingFound = false;
//                     continue;
//                 }
//                 else if(!st.isEmpty()){
//                     st.pop();
//                     // System.out.println("Here else if 2.2____"+count);

//                 }
//                 isFirstClosingFound = false;
//             }
            
//         }
//         if(isFirstClosingFound){ 
//             if(!st.isEmpty()){
//                 count++;
//                 st.pop();
//             }
//             else{
//                 count+=2;
//             }
//         }
        
//         while(!st.isEmpty()){
//             count+=2;
//             st.pop();
//         }
//         return count;