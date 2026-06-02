class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> res = new HashMap<>();
        for(String str : strs){
            char [] a = str.toCharArray();
            Arrays.sort(a);
            String b = new String(a);
            res.putIfAbsent(b,new ArrayList<>());
            res.get(b).add(str);
        }
    List<List<String>> ans = new ArrayList<>();
    for(List<String> i: res.values()){
        ans.add(i);
    }
    return ans;
}
}