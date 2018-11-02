class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //Separate two situation
            if((nums[mid] < nums[left])){
                // 6,7,0,1,2,3,4,5
                if((target < nums[mid]) || (target >= nums[left])){ 
                    right = mid - 1;
                }
                else{                                                                  
                    left = mid + 1;                 
                }
            }
            else{   //(nums[mid] > nums[left])
                // 2,3,4,5,6,7,0,1
                if((target > nums[mid]) || (target < nums[left])){
                    left = mid + 1;                    
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
