class Solution {
    public int minOperations(int[] nums) {

        boolean isAlreadySorted = true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                isAlreadySorted = false;
            }
        }
        if(isAlreadySorted) return 0;
    
        int n  = nums.length;
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=(nums[i-1]+1)%n){
                isIncreasing = false;
            }
            if((nums[i]+1)%n!=(nums[i-1])){
                isDecreasing = false;
            }
        }

        //for 1 left rotate the cost is 1
        //for x right rotate the cost is  x+2 (i.e 2 reverse and x left rotate);
        if(isIncreasing){

            int leftRotateCount = n-nums[0];
            int rightRotateCount = nums[0];

            int leftCost = leftRotateCount;
            int rightCost = rightRotateCount+2;

            return Math.min(leftCost , rightCost);
        }

        //just keep the logic same for Decreasing Sorted rotated array 
        //just add 1 to the ans for the rotating the array to make it increasing and then aaply same logic
        if(isDecreasing){

            int leftRotateCount = n-nums[n-1];
            int rightRotateCount = nums[n-1];

            int leftCost = leftRotateCount+1;
            //here keep in mind
            //for x right rotate the cost is  x+2 (i.e 2 reverse and x left rotate);
            //for right roattion we already do the one reverse then we must cancle out the one reverse and 
            //reverse which make the aaray increasing 
            int rightCost = rightRotateCount+1;

            return Math.min(leftCost , rightCost);
            
        }
        return -1;

    }
}