class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int len = nums.length;        
        for(int i = 0; i < len; i++){
            if(hashmap.containsKey(nums[i])){
                if(Math.abs(hashmap.get(nums[i])-i)<=k){
                    return true;
                }                
            }
            hashmap.put(nums[i],i);            
        }
        return false;
    }
}
