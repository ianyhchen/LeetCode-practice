class Solution {
    public int pivotIndex(int[] nums) {        
        int len = nums.length;
        if(len == 0 || len == 1){
            return -1;
        }
        int sum = 0;
        for(int i: nums){
            sum += i;
        }
        //judge if the pivot index is 0
        if(sum-nums[0] == 0){
            return 0;
        }
        int left = 0;
        for(int i = 1; i < len; i++){
            left += nums[i-1];
            if((sum - left - nums[i]) == left){ //sum - left - nums[i] == right
                return i;
            }
        }
        return -1;
    }
}
