class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return true;
        }
        // map the char in s and t with the same position into a key-value pair (char sc, char tc)
        Map<Character,Character> hashmap = new HashMap<Character, Character>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(hashmap.containsKey(sc)){
                if(hashmap.get(sc) != tc){
                    return false;
                }
            }
            else{
                if(hashmap.containsValue(tc)){
                    return false;
                }
                else{
                    hashmap.put(sc,tc);
                }                
            }       
        }
        return true;
    }
}
