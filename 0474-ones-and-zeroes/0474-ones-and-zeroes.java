class Solution {
    int countOnes(String str){
        int ones = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                ones++;
            }
        }
        return ones;
    }
    int countZeroes(String str){
        int ones = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '0'){
                ones++;
            }
        }
        return ones;
    }
    int helper(String [] strs,int m , int n,int i,int [][][]dp){
        if(i == strs.length){
            return 0;
        }
        int ones = countOnes(strs[i]);
        int zeroes = countZeroes(strs[i]);
        if(dp[i][m][n] != -1){
            return dp[i][m][n];
        }
        if(m-zeroes<0 || n-ones<0){
            return helper(strs,m,n,i+1,dp);
        }
        int take  = 0;
        if(m-zeroes<=m && n-ones<=n){
            take = 1 + helper(strs,m-zeroes,n-ones,i+1,dp);
        }
     
        int skip = helper(strs,m,n,i+1,dp);
        return dp[i][m][n] = Math.max(take,skip);
        }
    
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][] dp = new int [strs.length][m+1][n+1];
        for(int i=0;i<strs.length;i++){
            for(int j =0;j<m+1;j++){
                for(int k=0;k<n+1;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper(strs,m,n,0,dp);
    }
}