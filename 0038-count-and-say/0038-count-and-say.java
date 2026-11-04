class Solution {
    public String countAndSay(int n) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        while(count<n){
            int cnt = 0;
            char prev = sb.charAt(0);
            StringBuilder sb1 = new StringBuilder();
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)==prev){
                    cnt++;
                }
                else{ 
                    sb1.append((char)(cnt + '0')).append(prev);
                    prev = sb.charAt(i);
                    cnt = 1;
                }
            }
            sb1.append((char)(cnt + '0')).append(prev);
            count++;
            sb=sb1;
        }
        return sb.toString();
    }
}