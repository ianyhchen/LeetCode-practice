class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();
        int len = input.length;
        //push '(' '[' '{' into stack, if input is ')' ']' '}', pop the stack
        for(int i = 0; i < len; i++){
            if(input[i] == '(' || input[i] == '[' || input[i] == '{'){
                stack.push(input[i]);
            }
            else{
                if(stack.isEmpty()){                    
                    return false;
                }
                if(input[i] == ')' && stack.peek() != '('){
                    return false;
                }
                if(input[i] == ']' && stack.peek() != '['){
                    return false;
                }
                if(input[i] == '}' && stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
