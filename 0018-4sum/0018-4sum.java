// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         Arrays.sort(nums);
//         Set<List<Integer>> ans = new HashSet<>();
//         // Map<Integer,Integer> map = new HashMap<>();
//         // Map<List<Integer>,Integer> ListCheck = new HashMap<>();
//         for(int i=0;i<=nums.length-4;i++)
//         {
//             for(int j=i+1;j<=nums.length-3;j++)
//             {   
//                 long sum = nums[i]+nums[j];
//                 long diff = target - sum;
//                 int left  =  j+1;
//                 int right =  nums.length-1;
//                 while(left<right){
//                     if(nums[left]+nums[right] > diff){
//                         right--;
//                     }
//                     else if(nums[left]+nums[right] <  diff){
//                         left++;
//                     }
//                     else{
                   
//                         ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                         while (left < right && nums[left] == nums[left + 1]) left++;
//                         while (left < right && nums[right] == nums[right - 1]) right--;

//                         left++;
//                         right--; 
                        
//                     }
                    
//                 }
//             }
                    
//         }
//         List<List<Integer>> listAns = new ArrayList<>(ans);
//         return listAns;
//     }
// }
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        Map<List<Integer>, Integer> ListCheck = new HashMap<>();

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) {

                Map<Integer, Integer> map = new HashMap<>();

                for (int k = j + 1; k < nums.length; k++) {

                    long sum = (long) nums[i] + nums[j] + nums[k];

                    long diff = (long) target - sum;

                    if (diff >= Integer.MIN_VALUE &&
                        diff <= Integer.MAX_VALUE &&
                        map.containsKey((int) diff)) {

                        List<Integer> x = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],(int) diff) );

                        x.sort(Comparator.naturalOrder());

                        if (!ListCheck.containsKey(x)) {
                            ans.add(x);
                            ListCheck.put(x, 1);
                        }
                    }

                    map.put(nums[k], k);
                }
            }
        }

        return ans;
    }

}