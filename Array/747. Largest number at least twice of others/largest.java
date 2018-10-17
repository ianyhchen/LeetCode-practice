class Solution {
    public int dominantIndex(int[] nums) {
        int len =nums.length;
        if(len == 1){
            return 0;
        }
        //find the largest and second large number
        int large = 0, second = 0, index = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] > large){
                second = large;
                large = nums[i];
                index = i;
            }
            else if(nums[i] > second){
                second = nums[i];
            }
        }
        //System.out.println("large:"+large+" second:"+second);
        if(large >= 2*second){
            return index;
        }
        else{
            return -1;
        }
    }
}
