class Solution {

    boolean isValid(String s) {
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openCount++;
            } 
            else if (ch == ')') {
                openCount--;

                if (openCount < 0) {
                    return false;
                }
            }
        }

        return openCount == 0;
    }

    void Solve(String s, int i, String str, List<String> ans, int[] maxStrLen, Set<String> visited) {

        if (i == s.length()) {
            return;
        }

        String stateKey = i + "|" + str;

        if (visited.contains(stateKey)) {
            return;
        }

        visited.add(stateKey);


        String newStr = str + s.charAt(i);

        if (isValid(newStr)) {
            ans.add(newStr);
            maxStrLen[0] = Math.max(maxStrLen[0], newStr.length());
        }

        Solve(s, i + 1, newStr, ans, maxStrLen, visited);


        Solve(s, i + 1, str, ans, maxStrLen, visited);
    }

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();
        List<String> ans1 = new ArrayList<>();

        int[] maxStrLen = new int[]{0};

        Set<String> visited = new HashSet<>();

        Solve(s, 0, "", ans, maxStrLen, visited);

        Set<String> unique = new HashSet<>();

        for (String ss : ans) {
            if (ss.length() == maxStrLen[0]) {
                unique.add(ss);
            }
        }

        ans1.addAll(unique);

        if (ans1.size() == 0) {
            ans1.add("");
        }

        return ans1;
    }
}