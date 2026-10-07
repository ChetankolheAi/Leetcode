class Solution {
    public int secondHighest(String s) {
        int Maxi = -1;
        int SecondMaxi = -1;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int digit = s.charAt(i)-'0';
                if(digit>Maxi){
                    SecondMaxi = Maxi;
                    Maxi = digit;
                }
                if(digit>SecondMaxi && digit<Maxi){
                    SecondMaxi = digit;
                }
            } 
        }
        return SecondMaxi;
    }
}