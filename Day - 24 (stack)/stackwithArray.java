class myStack {
    int stack[];
    int top;
    public myStack(int n) {
        // Define Data Structures
        stack = new int[n];
        top = n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top == stack.length ? true : false;
    }

    public boolean isFull() {
        // check if the stack is full
        return top == 0 ? true : false;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(!isFull())
        stack[--top] = x;
        else return ;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(!isEmpty())
        ++top;
        else return ;
    }

    public int peek() {
        // Returns the top element of the stack
        if(!isEmpty())
        return stack[top];
        else return -1;
    }
}