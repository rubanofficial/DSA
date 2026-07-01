class Solution {
    int helper(int [] nums,int i,int prev,int [][] dp){
        if(i == nums.length){
            return 0;
        }
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev])
            {
            take = 1 + helper(nums,i+1,i,dp);
        }
        int skip = helper(nums,i+1,prev,dp);
        return dp[i][prev+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {
        int [][] dp = new int [nums.length][nums.length+1];
        for(int []i : dp){
            Arrays.fill(i,-1);
        }
        return helper(nums,0,-1,dp);
    }
}