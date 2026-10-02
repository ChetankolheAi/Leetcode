class Solution {
    void FindNext(int openC , int closeC , int n  ,List<String>ans,StringBuilder sb){
        if(openC==closeC && closeC == n){
            String toAdd = sb.toString();
            ans.add(toAdd);
            return;
        }
        if(openC<n){
            FindNext(openC+1,closeC,n,ans,sb.append('('));
            sb.deleteCharAt(sb.length()-1);
          
        }
        if(closeC<openC){
            FindNext(openC,closeC+1,n,ans,sb.append(')'));
            sb.deleteCharAt(sb.length()-1);
        }

       
    }
    public List<String> generateParenthesis(int n) {
        Map<String,Integer>map = new HashMap<>();
        List<String>ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        FindNext(0,0,n,ans,sb);
        return ans;
    }
}
