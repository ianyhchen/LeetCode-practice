class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*int j = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                j++;                
            }
            else{
                j = 0;
            }
            if(j > max){
                max = j;
            }
        }
        return max;*/
        //two pointer solution
        int max = 0, l = 0, r = 0;
        while(r < nums.length){            
            if(nums[r] == 1){
                l = r;
                while(r < nums.length && nums[r] == 1){
                    r++;
                }
                max = Math.max(max, r - l);
            }
            else{
                r++;
            }            
        }
        return max;
        
    }
}
