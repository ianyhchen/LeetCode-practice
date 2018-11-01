class Solution {
    //Iterative
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = (left + right) / 2;            
            if(target > nums[middle]){
                left = middle +1 ;
            }
            else if(target < nums[middle]){
                right = middle - 1;
            }
            else{                
                return middle;
            }
            
        }
        return -1;
    }
    //Divide and Conquer
    /*public int search(int[] nums, int target) {
        return BinarySearch(nums, 0, nums.length - 1, target);
    }
    private int BinarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        int middle = (left + right) / 2;
        if(nums[middle] == target){
            return middle;
        }
        else if(target > nums[middle]){
            return BinarySearch(nums, middle + 1, right, target);
        }        
        return BinarySearch(nums, left, middle - 1, target);
              
    }*/
}
