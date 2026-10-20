import java.util.*;

class Solution {

    private boolean isRotation(int[] nums, int start1,
                               int[] sorted, int start2,
                               int k) {

        int[] pattern = new int[k];
        int[] text = new int[2 * k];

        for (int i = 0; i < k; i++) {
            pattern[i] = sorted[start2 + i];

            text[i] = nums[start1 + i];
            text[i + k] = nums[start1 + i];
        }

        return kmpSearch(text, pattern);
    }

    private boolean kmpSearch(int[] text, int[] pattern) {
        int n = text.length;
        int m = pattern.length;

        int[] lps = buildLPS(pattern);

        int i = 0, j = 0;

        while (i < n) {
            if (text[i] == pattern[j]) {
                i++;
                j++;

                if (j == m) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    private int[] buildLPS(int[] pattern) {
        int m = pattern.length;
        int[] lps = new int[m];

        int len = 0;
        int i = 1;

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }

        return lps;
    }

    public int sortableIntegers(int[] nums) {

        int n = nums.length;

        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        int ans = 0;

        boolean alreadySorted = true;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                alreadySorted = false;
                break;
            }
        }

        if (alreadySorted) ans++;

        for (int k = 2; k <= n; k++) {

            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n; start += k) {

                if (!isRotation(nums, start, sorted, start, k)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}

///----------------TLE--Solution-----------------------
// class Solution {
//      public boolean isSortable(List<Integer> l1, List<Integer> l2Sort) {
//         if (l1.size() != l2Sort.size()) {
//             return false;
//         }

//         // System.out.println(l1.size());
//         // for(int i=0;i<l1.size();i++){
//         //     System.out.print(l1.get(i)+",");
//         // }
//         // // System.out.println("=--------=");
//         // for(int i=0;i<l2Sort.size();i++){
//         //     System.out.print(l2Sort.get(i)+",");
//         // }

//         List<Integer> flatList = Stream.concat(l1.stream(), l1.stream()).collect(Collectors.toList());

//         int index = Collections.indexOfSubList(flatList, l2Sort);

//         return index != -1;
//     }
//     public int sortableIntegers(int[] nums) {

//         List<Integer>subarraySize = new ArrayList<>();
//         List<Integer>ansDivisor  = new ArrayList<>();
//         int[] numsSorted = Arrays.copyOf(nums, nums.length);
//         Arrays.sort(numsSorted);

//         int n = nums.length;
//         for(int i=2;i<=n;i++){
//             if(n%i == 0){
//                 subarraySize.add(i);
//             }
//         }
        
//         //Check for k=1 is array Sorted  already?
//         boolean isArraySorted = true;
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]>nums[i+1]){
//                 isArraySorted = false;
//                 break;
//             }
//         }
//         int ans = 0;
//         for(int i =0;i<subarraySize.size();i++){
//             int k = subarraySize.get(i);
//             boolean isKvalid = true;
//             for(int j=0;j<n;j+=k){
//                 List<Integer>l1 = new ArrayList<>(k);
//                 List<Integer>l2 = new ArrayList<>(k);

//                 for(int l = j ; l <= (j+(k-1)) ; l++){

//                     l1.add(nums[l]);
//                     l2.add(numsSorted[l]);
//                     // System.out.println(l);
//                 }
//                    // System.out.println("----------------------");
//                 if(!isSortable(l1 , l2)){
//                     System.out.println(k);
//                     isKvalid = false;
//                     break;
//                 }
//             }
//             if(isKvalid){
//                 System.out.println(k);
//                 ans+=k;
//             }
//         }
//         if(isArraySorted)ans+=1;
//         return ans;
//     }
// }