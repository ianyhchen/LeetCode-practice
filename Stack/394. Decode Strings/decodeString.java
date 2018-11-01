class Solution {
    public String decodeString(String s) {
        String res =  "";
        Stack<Integer> countStack = new Stack<>();  //store digits
        Stack<String> charStack =  new Stack<>();   //store character
        int index = 0;
        int len = s.length();
        while(index < len){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            }
            else if(s.charAt(index) == '['){//push the result string into stack and set to empty string
                charStack.push(res);
                res = "";
                index++;
            }
            else if(s.charAt(index) == ']'){   //add the res behind the last result
                StringBuilder tmp = new StringBuilder(charStack.pop());
                int times = countStack.pop();
                while(times > 0){
                    tmp.append(res);    //add the res behind the last result
                    times--;
                }
                res = tmp.toString();
                index++;
                
            }
            else{
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }
}
