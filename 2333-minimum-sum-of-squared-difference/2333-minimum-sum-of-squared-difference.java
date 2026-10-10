
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int max = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (k >= sum) {
            return 0;
        }

        int low = 0, high = max;

        while (low < high) {
            int mid = low + (high - low) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int limit = low;
        long remaining = k;
        long ans = 0;

        for (int d : diff) {
            if (d > limit) {
                remaining -= d - limit;
                d = limit;
            }
            ans += (long) d * d;
        }

       
        if (remaining > 0) {
            ans -= remaining * (2L * limit - 1);
        }

        return ans;
    }
}

// class Pair {
//     int difference;
//     int index; 

//     public Pair(int difference, int index) {
//         this.difference = difference;
//         this.index = index;
//     }
// }
// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
//         long ans = 0;
//         System.out.println(k1+k2);
//         System.out.println("====");
//         PriorityQueue<Pair> pq = new PriorityQueue<>(
//             (a, b) -> Integer.compare(b.difference, a.difference)
//         );
//         int k1Op = 0;
//         int k2Op = 0;
//         for(int i=0;i<nums1.length;i++){
//             int diff = Math.abs(nums1[i]-nums2[i]);
//             pq.add(new Pair(diff,i));
//         }
        
//         while (!pq.isEmpty()) {
//             Pair p = pq.poll();
//             System.out.println(p.difference +","+ p.index);

//             int n1 = nums1[p.index];
//             int n2 = nums2[p.index];

//             if(k1Op < k1){
//                 if(n1<n2){
//                     nums1[p.index]++;
//                 }
//                 else {
//                     nums1[p.index]--;
//                 }
//                 k1Op++;
//             }
//             else if(k2Op < k2){
//                 if(n1>n2){
//                     nums2[p.index]++;
//                 }
//                 else {
//                     nums2[p.index]--;
//                 }
//                 k2Op++;
//             }
//             if(k2Op==k2 && k1Op==k1){
//                 break;
//             }
           
//             int diff1 = Math.abs(nums1[p.index]-nums2[p.index]);
//             System.out.println("---");
//             if(diff1==0)continue;
//             pq.add(new Pair(diff1,p.index));
//         }
//         //System.out.println(k1Op+","+k2Op);
//         for(int i=0;i<nums1.length;i++){
//             int diff = Math.abs(nums1[i]-nums2[i]);
//             ans+=Math.pow(diff,2);
//         }
//         return ans;

//     }
// }