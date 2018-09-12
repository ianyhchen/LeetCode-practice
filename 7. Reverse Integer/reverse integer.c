int reverse(int x) {
    bool isNegative = (x<0);    
    if (isNegative){
        x *= -1;
    }
    long result = 0; //prevent overflow
    int tmp = x;
    while(true){
        int digit = tmp % 10;
        result = result * 10 + digit;
        tmp /= 10;
        if(tmp == 0){
            break;
        }
    }
    if (isNegative){
        result *= -1;
    }    
    if (result < (-pow(2,31)) || result > (pow(2,31)-1)){
        return 0;
    }
    else{
        return result;
    }
    
    
}
