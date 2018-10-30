class MinStack {
    private Stack<Integer> datastack;
    private Stack<Integer> minstack;
    /** initialize your data structure here. */
    public MinStack() {
        datastack = new Stack<Integer>();
        minstack = new Stack<Integer>();        
    }
    
    public void push(int x) {
        datastack.push(x);
        if(minstack.isEmpty() || x <= minstack.peek()){
            minstack.push(x);
        }        
    }
    
    public void pop() {
        // Cannot write like the following:
        // if (datastack.peek() == minstack.peek()) minstack.pop();
        // datastack.pop();
        int data = datastack.peek();
        if( data == minstack.peek()){
            minstack.pop();
        }
        datastack.pop();
        
    }
    
    public int top() {
        return datastack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
