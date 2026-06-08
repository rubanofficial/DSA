class Solution {
    int fres(int[] n, int t){
        int l = 0;
        int r = n.length-1;
        int ans = -1;
        while(l<=r){
            int mid = (l + r)/2;
            if(n[mid] == t){
                ans = mid;
                r = mid-1;
            }
            else if(n[mid] > t){
                r = mid-1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
    int sres(int[] n, int t){
        int l = 0;
        int r = n.length-1;
        int ans = -1;
        while(l<=r){
            int mid = (l + r)/2;
            if(n[mid] == t){
                ans = mid;
                l = mid+1;
            }
            else if(n[mid] > t){
                r = mid-1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int [2];
        res[0] = fres(nums,target);
        res[1] = sres(nums,target);
        return res;
    }
}