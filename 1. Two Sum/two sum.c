/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target) {
    int *arr = malloc(2*sizeof(int));
    int flag = 0;
    for(int i = 0; i < numsSize; i++ )
    {
        for(int j = i+1; j < numsSize; j++)
        {
            if(nums[j] == target - nums[i])
            {
                arr[0] = i;
                arr[1] = j;
                flag = 1;
                break;
            }
        }
        if(flag == 1)
        {
            break;
        }
    }
    return arr;
}
