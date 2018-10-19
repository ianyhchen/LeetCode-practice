public class Solution {
    public String reverseWords(String s) {
        //two-pointers solution (no trim( ), no split( ), no StringBuilder)
       if(s == null){
           return null;
       }
        char[] words = s.toCharArray();
        int len = words.length;
        //reverse the whole string
        reverse(words, 0, len-1);
        
        //reverse each word
        reverseWords(words,len);
        
        //clean up space
        return cleanSpaces(words, len);
        
        
    }
    void reverseWords(char[] arr, int len){
        int i = 0, j = 0;
        while(i < len){
            while(i < j || i < len && arr[i] == ' ') i++; //skip space
            while(j < i || j < len && arr[j] != ' ') j++; //skip non space
            reverse(arr, i, j-1);                         //reverse the word
            
        }
    }
    
    private String cleanSpaces(char[] arr, int len){
        int i = 0, j = 0;
        while(j < len){
            while(j < len && arr[j] == ' ') j++;                //skip space
            while(j < len && arr[j] != ' ') arr[i++] = arr[j++];//skip non space
            while(j < len && arr[j] == ' ') j++;                //skip space
            if(j < len){                                        //add only one space between words
                arr[i++] = ' ';
            }
           
        }
        return new String(arr).substring(0,i);
    }
    
    private void reverse(char[] arr, int i, int j){
        while(i < j){
            char tmp = arr[j];
            arr[j--] = arr[i];
            arr[i++] = tmp;
        }
    }
}
