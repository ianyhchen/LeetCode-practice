class Solution {
    public String reverseWords(String s) {
        //built-in split function solution
        /*String[] words = s.split(" ");
        int length = words.length;
       
        StringBuilder output = new StringBuilder(); //use StringBuilder to append string is faster than simply plus two strings
        for(String index: words){
            output.append(reverse(index) + " "); 
        }
        return output.substring(0, output.length()-1);*/        
        String[] words = split(s);
        StringBuilder output = new StringBuilder();
        for(String word: words){
            output.append(reverse(word) + " ");
        }
        return output.toString().trim();    //use trim to delete the whitespace in the head and tail of the string
        
    }
    private String[] split(String s){
        List<String> wordsList = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                wordsList.add(word.toString());
                word = new StringBuilder();
            }
            else{
                word.append(s.charAt(i));
            }
        }
        wordsList.add(word.toString()); //add the last word
        return wordsList.toArray(new String[wordsList.size()]);
    }
    private String reverse(String s){
        char[] arr = s.toCharArray();
        int len = arr.length;        
        for(int i = 0; i < len/2; i++){
            char tmp = arr[len-1-i];
            arr[len-1-i] = arr[i];
            arr[i] = tmp;
        }
        String res = new String(arr);
        return res;
    }
}
