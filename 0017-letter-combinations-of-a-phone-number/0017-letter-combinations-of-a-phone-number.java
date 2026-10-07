class Solution {
    void Solve(String str ,int idx, String str1 ,Map<Integer,String> map ,String digits ,List<String> ans ){
        if(str1.length()==digits.length()){
            ans.add(str1);
            return;
        }
        if(idx == digits.length()) return ;
        int ch = digits.charAt(idx)-'0';
        String strCh = map.get(ch);
        System.out.println(strCh);
        
        for(int i=0;i<strCh.length();i++){
            
            Solve(str,idx+1,str1+strCh.charAt(i) , map,digits,ans); 

            Solve(str,idx+1,str1, map,digits,ans);    
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

        int ch = digits.charAt(0)-'0';
        String strCh = map.get(ch);
        Solve("",0,"",map,digits,ans);

        return ans;
    }
}