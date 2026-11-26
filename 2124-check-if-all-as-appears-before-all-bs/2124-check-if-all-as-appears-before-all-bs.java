class Solution {
    public boolean checkString(String s) {
        boolean isFoundB = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a'){ 
                if(isFoundB == true) return false;
            }
            if(s.charAt(i) == 'b'){
                isFoundB = true;
            }
        }
        return true;
    }
}