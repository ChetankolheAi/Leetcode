class Solution {

    void FindNext(int[] nums , List<List<Integer>>ans ,  List<Integer>temp , int i ,Map<List<Integer>, Integer> mp ){
        if(i>=nums.length){
            return;
        }
        temp.add(nums[i]);
        if(!mp.containsKey(temp)){
            ans.add(new ArrayList<>(temp));
            mp.put(temp,1);
        }
        FindNext(nums,ans,temp,i+1,mp);
        temp.remove(temp.size()-1);
        FindNext(nums,ans,temp,i+1,mp);


    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        Map<List<Integer>, Integer> mp = new HashMap<>();
        ans.add(new ArrayList<>(temp));
        FindNext(nums,ans , temp ,0,mp);
        return ans;
    }
}