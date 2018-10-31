class Solution {
    //Brute force DFS O(n^2)
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return count; 
        calculate(nums, 0, 0, S);
        return count;
    }
    private void calculate(int[] nums, int i, int sum, int S){
        if(i == nums.length){
            if(sum == S){
                count++;
            }
        }
        else{
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }    
}
