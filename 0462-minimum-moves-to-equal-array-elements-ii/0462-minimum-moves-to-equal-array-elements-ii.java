class Solution {
    
    
    public int findMedian(int[] arr) {
        int n = arr.length;
      
        // First we sort the array
        Arrays.sort(arr);

        // check for even case
        if (n % 2 != 0)
            return arr[n / 2];

        return (arr[(n - 1) / 2] + arr[n / 2]) / 2;
    }
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = findMedian(nums);
        System.out.println(median);
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count += Math.abs(nums[i]-median);
        }
        return count;
        // [2,3,3,5,3];
    }
}
// [0,0,1,8,6] nums.length/2;
// [0,0,1,1,8,6] (nums.length/2+(nums.length/2)-1)/2;
