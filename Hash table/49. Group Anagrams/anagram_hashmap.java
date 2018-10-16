class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>(); 
        if(strs == null || strs.length == 0){
            return result;
        }
        Map<String,List<String>> hashmap = new HashMap<String,List<String>>();
               
        for(String s: strs){
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            if(!hashmap.containsKey(key)){
                hashmap.put(key,new ArrayList<String>());
            }
            hashmap.get(key).add(s); //add string s into the list in value
        }
        for(List<String> l:hashmap.values()){
            //System.out.println(l);
            result.add(l);
        }
        
        return result;
    }
    
}
