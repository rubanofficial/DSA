class Solution {
    boolean helper(int [] p ,int mid , int h){
        long ans = 0;
       for(int i =0;i<p.length;i++){
         ans =  ans + ((long)p[i]+mid - 1)/mid;
       }
       return ans <=h;
    }
    public int minEatingSpeed(int[] p, int h) {
        int a = 0;
        for(int i=0;i<p.length;i++){
            if(p[i] > a){
                a = p[i];
            }
        }
        int low = 1;
        int high = a;
        int mid = 0;
        Arrays.sort(p);
        int res = a;
        while(low <= high){
            mid = low + (high - low)/2;
            if(helper(p,mid,h)){
                res = mid;
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
}