char* reverseString(char* s) {
    int length = strlen(s);
    int half = length/2;
    char* t;
    for(int i = 0; i < half; i++){
        t = s[length-1-i];
        s[length-1-i] = s[i];
        s[i] = t;
    }
    return s;
}
