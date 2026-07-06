class MinStack {
    
    Stack<Integer> stk;
    LinkedList<Integer> ll;
    public MinStack() {
        stk = new Stack<>();
        ll = new LinkedList<>();
    }
    
    public void push(int value) {
        int min = value;
        if(ll.size() > 0){
            min = Math.min(min , ll.getLast());
        }
        ll.add( min );
        stk.push(value);
    }
    
    public void pop() {
        if(!stk.isEmpty()){
            ll.removeLast();
            stk.pop();
        }
    }
    
    public int top() {
        if(!stk.isEmpty()){
            return stk.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!stk.isEmpty()){
           return ll.getLast();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */