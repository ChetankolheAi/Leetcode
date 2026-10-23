class Solution {
    public int longestOnes(int[] nums, int k) {
        int k1 = k;
        int maxLength = 0;
        int crrlength = 0;
        int j = 0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==1){
                crrlength++;
            }
            else if(nums[i]==0 && k1!=0){
                k1--;
                crrlength++;
            }
            else if(nums[i]==0 && k1==0){
                maxLength = Math.max(maxLength,crrlength);
                while(nums[j]!=0){
                    j++;
                }
                j++;
                crrlength = i-j+1;

            }

        }
        maxLength = Math.max(maxLength,crrlength);
        return maxLength;

    }
}