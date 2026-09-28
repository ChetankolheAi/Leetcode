class Solution {
    public int maxDepth(String s) {
        Stack<Character> st=new Stack<>();
        int maxD=0;
        int crrD=0;
        

        for(int i=0;i<s.length();i++){
          
            if(s.charAt(i) == ')') crrD--;
            else if(s.charAt(i) == '(') crrD++;
    
            maxD = Math.max(maxD,crrD);
        
        }
        return maxD;
    }
}