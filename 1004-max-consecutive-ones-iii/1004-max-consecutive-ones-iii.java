class Solution {
    public int longestOnes(int[] nums, int k) {
    
        int maxLength = 0;
        int crrlength = 0;
        int leftCounter = 0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==1){
                crrlength++;
            }
            else if(nums[i]==0 && k!=0){
                k--;
                crrlength++;
            }
            else if(nums[i]==0 && k==0){
                maxLength = Math.max(maxLength,crrlength);
                while(nums[leftCounter]!=0){
                    leftCounter++;
                }
                leftCounter++;
                crrlength = i-leftCounter+1;

            }

        }
        maxLength = Math.max(maxLength,crrlength);
        return maxLength;

    }
}