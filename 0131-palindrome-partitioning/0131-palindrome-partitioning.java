class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        for (int len = 1; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (len == 1) {
                    dp[i][j] = true;
                }
                else if (len == 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j))
                            && dp[i + 1][j - 1];
                }
            }
        }

        backtrack(0, s, dp, new ArrayList<>());

        return res;
    }

    private void backtrack(int start,String s,boolean[][] dp,List<String> path) {

        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {

                path.add(s.substring(start, end + 1));

                backtrack(end + 1, s, dp, path);
                path.remove(path.size() - 1);
            }
        }
    }
}