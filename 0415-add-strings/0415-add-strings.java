class Solution {
    public String addStrings(String num1, String num2) {

        //do -48;
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            int n1 = num1.charAt(i)-48;
            int n2 = num2.charAt(j)-48;
            int sum = n1+n2+carry;
            int toAdd = sum%10;
            carry = sum/10;
            sb.append(toAdd);
            i--;
            j--;
        }
        while(i>=0){
            int n1 = num1.charAt(i)-48;
            int sum = n1+carry;
            int toAdd = sum%10;
            carry = sum/10;
            sb.append(toAdd);
            i--;
        }
        while(j>=0){
         
            int n2 = num2.charAt(j)-48;
            int sum = n2+carry;
            int toAdd = sum%10;
            carry = sum/10;
            sb.append(toAdd);
            j--;
        }
        if(carry>0){
            sb.append('1');
        }
        sb.reverse();
        String ans =  sb.toString();
        return ans;
    }
}