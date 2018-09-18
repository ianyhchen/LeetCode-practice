#include <stdio.h>
#include <string.h>
#include <stdbool.h>
bool check(int* arr);
bool checkInclusion(char* s1, char* s2) {
    int len_s1 = strlen(s1);
    int len_s2 = strlen(s2);
    if(len_s1 > len_s2){
        return false;
    }
	//hash table: key(alphabet),value(count)
    int arr[26] = {0};
    for(int i = 0; i<len_s1; i++){
        arr[s1[i]-'a']++;
        arr[s2[i]-'a']--;
    }
    if(check(arr)){
        return true;
    }
	//a slide window	
    for(int j = len_s1; j < len_s2; j++){
        arr[s2[j]-'a']--; //decrease the count when go into the window
        arr[s2[j-len_s1]-'a']++;// increase the count when leave the window
        /*for(int k = 0; k<26;k++){
                printf("%d",arr[k]);
        }*/
        //printf("\n");
        if(check(arr)){           
            
            return true;
        }
    }
    return false;    
}
bool check(int* arr){    
    for(int i = 0; i < 26; i++){
        if(arr[i] != 0){
            return false;
        }
    }
    return true;
}

int main(){
	printf(checkInclusion("hello","ooolleoooleh")? "true":"false");
}
