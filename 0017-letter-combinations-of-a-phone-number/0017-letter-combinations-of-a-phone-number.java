class Solution {


    /// Solved this Problem Within 13 Min and without a single visit to CHATGPT or any Other AI .
    //
    void Solve( Map<Integer,String> map , List<String> ans, int idx, String str1 ,String digits ){
        
        if(str1.length()==digits.length()){
            ans.add(str1);
            return;
        }
        if(idx == digits.length()) return;
        

        int ch = digits.charAt(idx)-'0';
        String strCh = map.get(ch);

        
        for(int i=0;i<strCh.length();i++){
            
            Solve(map,ans,idx+1,str1+strCh.charAt(i),digits); 

            Solve(map,ans,idx+1,str1,digits);    
        }
        
    }
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map= new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> ans = new ArrayList<>();

        Solve(map,ans,0,"",digits);

        return ans;
    }
}