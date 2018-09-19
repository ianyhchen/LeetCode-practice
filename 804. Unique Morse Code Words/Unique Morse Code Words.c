#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int uniqueMorseRepresentations(char** words, int wordsSize) {
    if(wordsSize==0){
        return 0;
    }
    char* morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    char* transformation[wordsSize]; //array to store strings
    char* trans;
    for(int i = 0; i < wordsSize; i++){ //traverse each words
        trans = (char*)malloc(100*(sizeof(char))); //allocate enough size  
		//char trans[]={0};
        int len = strlen(words[i]);
        char* temp = words[i];
		
        for(int j = 0; j < len; j++){       // traverse each char in word      
			strcat(trans,morse[temp[j]-'a']);  // add the morse code into the string          
        }
        //char t[100];
        //strcpy(t,trans);
        //printf("before %d %s\n",i,*(transformation));
		transformation[i] = trans;
		//printf("%d %s\n",i,transformation[i]);				
    }
    //printf("zero %d %s\n",0,transformation[0]);
    int count_t[wordsSize];  //the array to judge if the code is not duplicate 
    for(int i = 0; i < wordsSize; i++){
        count_t[i] = 1; //set all the value to 1
    }
    
    /*int count = 0;
	if(transformation){
         count = 1;        	
        //printf("i: %d %s\n",0,*(transformation+0));
        temp_t[0] = transformation[0];
    }
    else{
        return 0;
    }*/
    
    for(int i = 0; i < wordsSize-1; i++){
        //printf("i:%d %s\n",i,transformation[i]);
        if(count_t[i] == 1){
            for(int j =i+1; j < wordsSize; j++){
                if(strcmp(transformation[i],transformation[j]) == 0){ //if the code is the same, set the count to zero
                    //printf("same :%s %s\n",transformation[i],temp_t[j]);
                    count_t[i] = 0;
                }                
            }
        }
    }
    int count = 0;
	for(int i = 0; i < wordsSize; i++){
        if(count_t[i] == 1){
            count++;
            printf("%d: %s %s,",i,words[i],transformation[i]);
        }
    }
	
    return count;
}
