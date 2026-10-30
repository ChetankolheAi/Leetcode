class Solution {
    public String intToRoman(int num) {
        int[] values = {
            1000, 900, 500, 400, 100, 90,
            50, 40, 10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC",
            "L", "XL", "X", "IX", "V", "IV", "I"
        };

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(num>0 && i<values.length){
            if(values[i]<=num){
                int toAdd = num / values[i];
                for(int k = 0;k<toAdd;k++){
                    sb.append(symbols[i]);
                }
                num %= values[i];
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }
}