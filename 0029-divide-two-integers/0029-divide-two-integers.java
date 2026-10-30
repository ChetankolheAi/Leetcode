class Solution {
    public int divide(int dividen, int diviso) {
        if(diviso == 1) return dividen;
        int count = 0;
        boolean isNegativedivisor = false;
        boolean isNegativedividend = false;
        long dividend = dividen;
        long divisor = diviso;
        if(divisor < 0)
        {

            // if(divisor == Integer.MIN_VALUE) divisor =  Integer.MAX_VALUE;
             divisor = divisor+Math.abs(divisor)+Math.abs(divisor);

            isNegativedivisor = true;
            System.out.println(dividend);
        }
        if(dividend < 0)
        {

            //if(dividend == Integer.MIN_VALUE)   dividend =  Integer.MAX_VALUE;
            dividend = dividend+Math.abs(dividend)+Math.abs(dividend);
            
            isNegativedividend = true;
            System.out.println(dividend);
        }
        if(divisor > dividend) return 0;

        while(dividend>=divisor ){
            count++;
            dividend-=divisor;
        }

        if(isNegativedivisor && isNegativedividend) {
            if(count == Integer.MIN_VALUE)
            {
                count = Integer.MAX_VALUE;   
            }
            return count;
       
         } else if(isNegativedivisor || isNegativedividend) count = count-(count+count);
        

        return count;
    }
}

