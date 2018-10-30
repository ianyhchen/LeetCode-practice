class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();        
        for(String i: tokens){
            if(!i.equals("+")&& !i.equals("-")&& !i.equals("*")&& !i.equals("/")){
                stack.push(Integer.parseInt(i));
            }
            else{
                int a = stack.pop();                
                int b = stack.pop();                
                int res = 0;
                switch(i){
                    case "+":
                        res = b + a;
                        break;
                    case "-":
                        res = b - a;
                        break;
                    case "*":
                        res = b * a;
                        break;
                    case "/":
                        res = b / a;
                        break;
                }
                stack.push(res);
            }
        }
        return stack.peek();
    }
}
