class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Set solution
        /*Set<Character> hashset = new HashSet<>();
        int len = s.length();
        int left = 0, right = 0;
        int max = 0;
        while(left < len && right < len){
            if(!hashset.contains(s.charAt(right))){
                hashset.add(s.charAt(right++));
                max = Math.max(max,right-left);
            }
            else{
                hashset.remove(s.charAt(left++));
            }
        }
        return max;  */
        
        //HashMap solution
        Map<Character, Integer> hashmap = new HashMap<>();
        int len = s.length();
        int i = 0, ans = 0;        
        for(int j = 0; j < len; j++){
            //The reason is that if s[j] have a duplicate in the range [i, j) with index j', 
            //we don't need to increase i little by little. We can skip all the elements in the range [i, j']
            //and let i to be j'+1 directly.
            if(hashmap.containsKey(s.charAt(j))){
                i = Math.max(hashmap.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            hashmap.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
