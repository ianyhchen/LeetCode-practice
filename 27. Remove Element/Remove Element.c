int removeElement(int* nums, int numsSize, int val) {
    if(numsSize == 0){
        return 0;
    }
    int i = 0;
    int size = numsSize;
    while(i < size){
        if(nums[i] == val){   
            nums[i] = nums[size-1]; //swap the value at i with the last element, and decrease the size
            size--;                 //-->reduce the needs to traverse when the elements to remove are rare. 
        }
        else{
            i++;
        }
    }    
    return size;
}
