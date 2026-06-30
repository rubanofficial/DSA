class Solution {
    Boolean [][] memo;
    boolean helper(int[] n,int i,int t){
        if(t==0){
            return true;
        }
        if(i==n.length || t<0){
            return false;
        }
        if(memo[i][t]!=null){
            return memo[i][t];
        }
        boolean take = helper(n,i+1,t-n[i]);
        boolean skip = helper(n,i+1,t);
        return  memo[i][t] = take|| skip ;
    }
    public boolean canPartition(int[] n) {
        int s = 0;
        for(int i:n){
            s = s + i;
        }
        if(s%2!=0){
            return false;
        }
        int t = s/2;
        memo = new Boolean[n.length][t+1];
        return helper(n,0,t);
    }
}