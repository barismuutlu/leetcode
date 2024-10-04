class MinStack {

    List<Integer> stack = new ArrayList<>();
    Stack<Integer> minimumStack = new Stack<>();
    //To Finding minimum Value in the Stack in o(1), i used another Stack as minimumStack
    int top = -1;
    public MinStack() {
    }
    
    public void push(int val) {
        if(minimumStack.empty() || minimumStack.peek() >= val)
        {
            minimumStack.push(val);
        }
        stack.add(val);
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
         int removedValue = stack.getLast();
         stack.removeLast();
        if (removedValue == minimumStack.peek()) {
            minimumStack.pop();
        }

    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minimumStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
