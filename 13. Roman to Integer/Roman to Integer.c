int getNum(char c){
    int k = 0;
    switch(c){
            case 'I':
                k = 1; 
                break;
            case 'V':                
                k = 5;    
                break;     
            case 'X':
                k = 10;    
                break;     
            case 'L':
                k = 50;    
                break;     
            case 'C':
                k = 100;    
                break;     
            case 'D':
                k = 500;    
                break;     
            case 'M':
                k = 1000;    
                break; 
            default:
                break;
    }
    return k;
}
int romanToInt(char* s) {
    int len = strlen(s);
    int value = 0, i = 0;
    while(s[i] != NULL){
        int x = getNum(s[i]);
        int y = s[i+1] != NULL ? getNum(s[i+1]) : 0;
        if(y != 0 && getNum(s[i+1]) > x){ //ex. IV = V - I = 4
            value = value + y - x;
            i += 2;
        }
        else{
            value = value + x;
            i++;
        }
    }
    //char prev = NULL;
    
    return value;
}
