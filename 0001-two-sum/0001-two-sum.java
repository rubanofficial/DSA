class Solution {
    public int[] twoSum(int[] nums, int t) {
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int []{map.get(nums[i]),i};
            }
            map.put(t - nums[i],i);
        }
        return new int []{};
    }
}