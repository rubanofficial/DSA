class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String,List<String>> map = new HashMap<>();
        for(String i : strs){
            char [] a = i.toCharArray();
            Arrays.sort(a);
            String b = new String(a);
            map.putIfAbsent(b,new ArrayList<>());
        }
        List<List<String>> res = new ArrayList<>();
        for(String i : strs){
            char [] a = i.toCharArray();
            Arrays.sort(a);
            String b = new String(a);
            if(map.containsKey(b)){
                map.get(b).add(i);
            }
        }
        for(List i : map.values()){
            res.add(i);
        }
        return res;
    }
}