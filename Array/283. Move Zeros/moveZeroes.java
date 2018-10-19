class Solution {
    public void moveZeroes(int[] nums) {
        //Bad time complexity solution O(n^3)
        /*int r = 0;              
        for(int l = 0; l < nums.length; l++){
            r = l;
            if(nums[l] == 0){
                while(r < nums.length && nums[r] == 0){
                    r++;
                }
                if(r == nums.length){
                    break;
                }
                if(nums[r] != 0){
                    int tmp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = tmp;                    
                }
            }
            
        }  */
        //O(n) solution
        /*int lastNoneZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lastNoneZero++] = nums[i];
            }
        }
        for(int j = lastNoneZero; j < nums.length; j++){
            nums[j] = 0;
        }*/
        
        int lastNoneZero = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){   //swap when the value is not 0
                int tmp = nums[i];
                nums[i] =  nums[lastNoneZero];
                nums[lastNoneZero++] = tmp;
            }
        }
    }
}
