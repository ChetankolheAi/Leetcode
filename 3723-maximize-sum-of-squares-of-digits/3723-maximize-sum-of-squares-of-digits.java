class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int nineCount = sum/9;
        int toAddLstDigit = sum%9;

        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<nineCount;i++){
            sb.append('9');
        }
        if( toAddLstDigit != 0 && nineCount+1 > num) return "";
        if( toAddLstDigit != 0 ) sb.append((char)(toAddLstDigit+'0'));

        int j = sb.length();
        
        while(j < num){
            sb.append('0');
            j++;
        }

        String ans = sb.toString();
        return ans;
    }
}