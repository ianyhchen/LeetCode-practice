int removeDuplicates(int* nums, int numsSize) {
    if(numsSize == 0){
        return 0;
    }
    //set two pointer to traverse the array
    int i = 0; //slow pointer
    for(int j = 1; j < numsSize; j++){ //j fast pointer, increase j to skip duplicate
        if(nums[i] != nums[j]){ // if not the same, copy the value of j to i, increase i
            i++;
            nums[i] = nums[j];
        }
    }
    return i+1;
}
