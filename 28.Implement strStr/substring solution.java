class Solution {
    public int strStr(String haystack, String needle) {
        int len_n = needle.length(), len_h = haystack.length();
        if(len_h < len_n){
            return -1;
        }
        else if(len_n == 0){
            return 0;
        }
        int threshold = len_h - len_n;        
        for(int i = 0; i <= threshold; i++){
            if(haystack.substring(i,i+len_n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
