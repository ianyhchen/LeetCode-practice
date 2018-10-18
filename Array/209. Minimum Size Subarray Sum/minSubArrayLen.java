class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //Two pointer solution
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0, sum = 0;
        while(right < nums.length){
            sum += nums[right++];
            while(sum >= s){
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }                      
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }
}
