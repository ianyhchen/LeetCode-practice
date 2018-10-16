class Solution {
    public int firstUniqChar(String s) {
        // HashMap solution
        Map<Character, Integer> hashmap = new HashMap<Character, Integer>();        
        int len = s.length();        
        for(int i = 0; i < len; i++){            
            /*if(hashmap.containsKey(s.charAt(i))){
                hashmap.put(s.charAt(i),hashmap.get(s.charAt(i))+1);
            }
            else{
                hashmap.put(s.charAt(i),1);
            }*/            
            //System.out.println(s.charAt(i)+" "+hashmap.get(s.charAt(i)) );
            hashmap.put(s.charAt(i),hashmap.getOrDefault(s.charAt(i),0)+1);
        }        
        for(int i = 0; i < len; i++){
            if(hashmap.get(s.charAt(i)) == 1){
                return i;
            }            
        }
        return -1;        
    }
    
}
