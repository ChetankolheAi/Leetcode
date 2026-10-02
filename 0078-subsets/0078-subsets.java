class Solution {

    void FindNext(int[] nums , List<List<Integer>>ans ,  List<Integer>temp , int i  ){
        if(i>=nums.length){
            return;
        }
        temp.add(nums[i]);

        //----We can do with and without hashmap aswell ----------
        // if(!mp.containsKey(temp)){
        //     ans.add(new ArrayList<>(temp));
        //     mp.put(temp,1);
        // }

        ans.add(new ArrayList<>(temp));
        FindNext(nums,ans,temp,i+1);
        //---Backtrack previosly added element -------
        temp.remove(temp.size()-1);

        FindNext(nums,ans,temp,i+1);


    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        // Map<List<Integer>, Integer> mp = new HashMap<>();
        ans.add(new ArrayList<>(temp));
        // FindNext(nums,ans , temp ,0,mp);
        FindNext(nums,ans , temp ,0);
        return ans;
    }
}