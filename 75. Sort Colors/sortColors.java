class Solution {
    public void sortColors(int[] nums) {
        //bubble sort (low performance)
        /*int len = nums.length;
        for(int i = 0; i < len - 1; i++){
            int change = 0;
            for(int j = 1; j < len; j++){
                if(nums[j-1] > nums[j]){
                   int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                    change = 1; 
                }
                
            }
            if(change == 0){
                break;
            }
        }*/
        int second = nums.length - 1, zero = 0;
        for(int i = 0; i <= second; i++){
            while(nums[i] == 2 && i < second){
                swap(nums, i, second--);
            }
            while(nums[i] == 0 && i > zero){
                swap(nums, i, zero++);
            }
        }
    }
    void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
