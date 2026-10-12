class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>li = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                li.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }

        int ans[] = new int[li.size()];
        for(int i=0;i<li.size();i++){
            ans[i] = li.get(i);
        }
        return ans;
    }
}