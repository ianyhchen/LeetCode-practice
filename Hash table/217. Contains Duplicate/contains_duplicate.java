class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for(Integer i : nums){
            if(hashset.contains(i)){
                return true;
            }
            hashset.add(i);
        }
        return false;
        
    }
}
