class Solution {
    public int reverseDegree(String s) {
        int StringDegree = 0;
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            int charNum = 27-(c-96);
            
            StringDegree += ((i+1)*charNum);
        }
        return StringDegree;
    }
}