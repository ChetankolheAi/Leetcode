class Solution {
   boolean isValid(String s) {
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openCount++; 
            } else if (ch == ')') {
                openCount--; 
                
                if (openCount < 0) {
                    return false;
                }
            }
        }
        return openCount == 0;
   }
    void Solve(String s , int i , String str , List<String> ans ,  int[] maxStrLen ,Set<String> visited){

        if(i==s.length()){
            return ;
        }
        String stateKey = i + "#" + str;
        if (visited.contains(stateKey)) {
            return;
        }
        visited.add(stateKey);
        StringBuilder sb = new StringBuilder(str);
        sb.append(s.charAt(i));
        str = sb.toString();
        if(isValid(str)){
            ans.add(str);
            maxStrLen[0] = Math.max(maxStrLen[0] , str.length());
        }

        Solve(s,i+1,str , ans ,maxStrLen ,visited);

        StringBuilder sb1 = new StringBuilder(str);
        sb1.deleteCharAt(str.length()-1);
        str = sb1.toString();
        
        Solve(s,i+1,str , ans ,maxStrLen ,visited);
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        List<String> ans1 = new ArrayList<>();
        int[] maxStrLen = new int[]{0};
        Map<String,Integer> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Solve(s,0,"" , ans , maxStrLen,visited);
        for(String ss :  ans){
            if(map.containsKey(ss)){
                continue;
            }
            if(ss.length()==maxStrLen[0]){
                System.out.println(ss);
                ans1.add(ss);
            }
            map.put(ss,1);
        }
        if(ans1.size()==0) ans1.add("");
        return ans1;
    }
}