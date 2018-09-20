int removeDuplicates(int* nums, int numsSize) {
    if(numsSize == 0){
        return 0;
    }
    int i = 0;
    int count = 0; //count the duplicate number
    for(int j = 1; j < numsSize; j++){
        if(nums[i] == nums[j]){
            count++;
            if(count < 2){ //if appear not more than twice, increase i and store the value at pos j
                i++;
                nums[i] = nums[j];
            }
            
        }
        else if(nums[i] != nums[j]){ //reset count, increase i and store the value at pos j
            count = 0;
            i++;
            nums[i] = nums[j];            
        }
    }
    return i+1;
}
