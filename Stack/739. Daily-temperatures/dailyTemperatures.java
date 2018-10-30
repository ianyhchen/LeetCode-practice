class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();   //use stack to store the larger index
        for(int i = T.length -1; i >= 0; i--){
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]){ // if the value in index i is larger, update the stack (pop)
                stack.pop();
            }
            ans[i] = stack.isEmpty()? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
