// class Solution {
//     public int[] countServers(int n, int[][] logs, int x, int[] queries) {
//         Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
//         int ans[] = new int[queries.length];
        
//         for(int i=0;i<queries.length;i++){
//             Map<Integer,Integer> mp = new HashMap<>();
//             for(int j=0;j<logs.length;j++){
//                 if(logs[j][1]>=(queries[i]-x) && logs[j][1]<=queries[i]){
//                     mp.put(logs[j][0],1);
//                 }
//             }
//             ans[i]=n-mp.size();
//         }
//         return ans;
//     }
// }
//--------------------------Time Limit Exceeded 2127 / 3129 testcases passed-------------------
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];

        Map<Integer, Integer> mp = new HashMap<>();

        int left = 0, right = 0;
        int m = logs.length;

        for (int i = 0; i < q.length; i++) {

            int start = q[i][0] - x;
            int end = q[i][0];

            // Add logs within the right boundary
            while (right < m && logs[right][1] <= end) {
                mp.put(logs[right][0],
                       mp.getOrDefault(logs[right][0], 0) + 1);
                right++;
            }

            // Remove logs outside the left boundary
            while (left < right && logs[left][1] < start) {

                int id = logs[left][0];

                mp.put(id, mp.get(id) - 1);

                if (mp.get(id) == 0) {
                    mp.remove(id);
                }

                left++;
            }

            ans[q[i][1]] = n - mp.size();
        }

        return ans;
    }
}

