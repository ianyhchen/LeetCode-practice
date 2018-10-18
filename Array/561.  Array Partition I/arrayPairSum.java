class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int n = len/2;
        int sum = 0;
        for(int i = 0; i < len; i+=2){
            //sum += Math.min(nums[i-1], nums[i]);
            //In the sorted array, the maximum sum of min pairs will be the the sum of the small one in each pair. 
            sum += nums[i];
        }
        return sum;
          
    }
}
