#include <stdio.h>
#include <string.h>
#include <stdbool.h>
int firstUniqChar(char* s) {   
	int len = strlen(s);    
	int testcase[2][26];  
	for(int i = 0;i < 26; i++){
		testcase[0][i] = 0; // store the number of each char finding in string s
		testcase[1][i] = -1;// store the position of each char finding in string s
	}
    
	for(int i = 0;i < len; i++){
		int pos = s[i]-'a';
		testcase[0][pos]++;
		if(testcase[1][pos] ==-1){
			testcase[1][pos] = i;
		}
	}
	int first_unique = -1; // the pos of first unique charater
	for(int j = 0;j < 26; j++){
		if(testcase[0][j] == 1){
			if (first_unique == -1){ // record the pos of unique charater
				first_unique = testcase[1][j];
			}
			else if(testcase[1][j] < first_unique){ //find the first unique charater (the smallest pos)
				first_unique = testcase[1][j];
			}
		}
	}
    return first_unique;
}

int main(){
	printf("%d\n",firstUniqChar("loveleetcode"));
}
