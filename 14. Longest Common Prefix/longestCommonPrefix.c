char* longestCommonPrefix(char** strs, int strsSize) {
    char* temp;     //create a temporarily pointer
    if(strsSize <= 0){
        return "";
    }
    int j;
    temp = strs[0]; //set the first string to temp
    for(int i = 1; i < strsSize; i++){
        j = 0;      // traverse from first char for each strings  
        while(temp[j] && strs[i][j] && temp[j] == strs[i][j]){
            j++;
        }
        temp[j] = '\0';  //set '\0' to cut off the string
    }
    return temp;
}
