class Solution {
    public int[] finalPrices(int[] prices) {
        int ans[] = new int[prices.length];
        Stack<Integer>st = new Stack<>();
        int nextSmallest[] = new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){

            while(!st.isEmpty() && st.peek()>prices[i])
                st.pop();

            if(!st.isEmpty())
                nextSmallest[i] = st.peek();
            else 
                nextSmallest[i] = -1;

            st.push(prices[i]);
        }
        for(int i=0;i<prices.length;i++){

            if(nextSmallest[i]>0)
                ans[i] = prices[i]-nextSmallest[i];
            else
                ans[i] = prices[i];
            
        }
    
        return ans;
        
    }
}