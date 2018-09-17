char* toLowerCase(char* str) {
    int len = strlen(str);
    for(int i = 0; i < len; i++){
        if(str[i] >= 'A' && str[i] <= 'Z'){
            str[i] = str[i] - 'A' + 'a';            
        }
        //printf("%c",str[i]);
    }
    return str;
    
}
