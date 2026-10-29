class Solution {
        public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int a = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int b = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = a + b + carry;

            ans.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        return ans.reverse().toString();
    }
    public String multiply(String num1, String num2) {
                if(num2.equals("0") || num1.equals("0")) return "0";

        int j = num2.length()-1;
        String LastAns="";
        while(j>=0){
            StringBuilder sb = new StringBuilder();
            int outerNum = num2.charAt(j)-'0';
            int i = num1.length()-1;
            int carry = 0;
            for(int k=0;k<Math.abs(j-(num2.length()-1));k++){
                sb.append('0');
            }
            while(i>=0){
                int number = num1.charAt(i)-'0';
                int ans = (number*outerNum)+carry;
                int toAdd = ans%10;

                sb.append(String.valueOf(toAdd));
                ans/=10;
                carry = ans;
                i--;
            System.out.println(toAdd);
            }
            if(carry!=0){
                sb.append(String.valueOf(carry));
            }
            sb.reverse();
            LastAns = addStrings(LastAns,sb.toString());
            System.out.println(sb.toString());
            j--;
          
        }
        
            System.out.println(LastAns);
        return String.valueOf(LastAns);
    }
}