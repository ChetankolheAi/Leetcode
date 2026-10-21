class Solution {
    public int minOperations(String s) {

        int n = s.length();
        boolean isAlreadySorted = true;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) > s.charAt(i+1)){
                isAlreadySorted = false;
            }
        }
        if(isAlreadySorted) return 0;

        if(s.length()==2) return -1;
        int smallestIndex = 0;
        int smallest = Integer.MAX_VALUE;
        int largestIndex = 0;
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
                if(s.charAt(i)>largest){
                    largest = s.charAt(i);
                    largestIndex = i;
                }
                if(s.charAt(i)<smallest){
                    smallest = s.charAt(i);
                    smallestIndex = i;
                }
        }   
        if (s.charAt(0) == smallest || s.charAt(n - 1) == largest) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == smallest || s.charAt(i) == largest) {
                return 2;
            }
        }
        
        return 3;

      
    }
}


