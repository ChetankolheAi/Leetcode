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