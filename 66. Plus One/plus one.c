/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {     
    int* returnArr = (int*)malloc((digitsSize)*sizeof(int));     
     int sum = 0;     
     int last = 1;        
    for(int i = digitsSize-1; i >= 0; i--){
        sum = last + digits[i]; //plus one to the last digit
        last = sum / 10;        //the carry digit
        returnArr[i] = sum % 10;        
        printf("%d\n", returnArr[i]);
    }    
    int size;
    if(last > 0){ //if need to carry
        size = digitsSize+1;
        int* new_Arr = (int*)malloc((size)*sizeof(int)); //allocate memory for new array
        new_Arr[0] = last;                              //set the first digit
        for(int i = 1;i < size-1; i++){
            new_Arr[i] = returnArr[i-1];
        }
        *returnSize = size;
        return new_Arr;        
    }   
    *returnSize = digitsSize;
    return returnArr;
    
}
