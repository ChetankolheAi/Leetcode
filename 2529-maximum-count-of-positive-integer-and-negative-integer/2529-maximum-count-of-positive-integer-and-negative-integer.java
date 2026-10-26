class Solution {
    public int maximumCount(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]<=0){
                start = mid+1;
            }
            if(nums[mid]>0){
                end = mid-1;
            }

        }
        int positiveCount ;
        if(start==nums.length){
            positiveCount = 0;
        }
        else{
            positiveCount = nums.length-end-1;
        }
        System.out.println(start+","+end+","+positiveCount);


        start  = 0;
        end = nums.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(nums[mid]<0){
                start = mid+1;
            }
            if(nums[mid]>=0){
                end = mid-1;
            }

        }
        int negativeCount = end;
        if(end==-1){
            negativeCount = 0;
        }
        else{
            negativeCount = end+1;
        }
        System.out.println(start+","+end+","+negativeCount);


        return Math.max(negativeCount , positiveCount);

    }
}