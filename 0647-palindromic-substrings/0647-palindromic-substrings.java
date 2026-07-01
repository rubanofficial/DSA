class Solution {
    public int countSubstrings(String s) {
        boolean [][] dp = new boolean[s.length()][s.length()];
        int sum = 0;
        for(int len = 1;len<=s.length();len++){
            for(int i=0;i+len-1<s.length();i++){
                int j = i + len - 1;
                if(len == 1){
                    dp[i][j] = true;
                }
                else if(len == 2){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
                }
             if(dp[i][j]){
                sum++;
             }   
            }
        }
        return sum;
    }
}