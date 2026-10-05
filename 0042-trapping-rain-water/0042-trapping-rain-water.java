

class Solution {
    public int trap(int[] height) {
        int nextLargest[]  = new int[height.length];
        int prevLargest[]  = new int[height.length];

        int large = Integer.MIN_VALUE;  
        for(int i=height.length-1;i>= 0;i--){

                large = Math.max(large,height[i]);
                nextLargest[i] = large;

        }
        
        int large2 = Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            large2 = Math.max(large2,height[i]);
            prevLargest[i] = large2;
           
        }

        int trappedWater = 0;
        for(int i=0;i<height.length;i++){
            int ans = Math.min(prevLargest[i] , nextLargest[i]) - height[i];
            trappedWater += ans;
        }
        return trappedWater;
    }
}