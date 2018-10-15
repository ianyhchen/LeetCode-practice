class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int len = nums.length;
        int[] result = new int[2];
        for(int i = 0; i < len; i++){            
            if(hashmap.containsKey(target - nums[i])){
                result[0] = i;
                result[1] = hashmap.get(target - nums[i]);
            }            
            hashmap.put(nums[i],i);
        }
        return result;
    }
}
