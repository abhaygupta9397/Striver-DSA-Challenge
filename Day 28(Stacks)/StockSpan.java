class StockSpanner {
    
    int days;
    Stack<int[]> stk;
    
    public StockSpanner() {
        days = 0;
        stk = new Stack<>();
    }
    
    public int next(int price) {
        days++;
        int span = 1;  // at least today
        
        while (!stk.isEmpty() && stk.peek()[0] <= price) {
            span += stk.pop()[1];  // add the span of the popped day
        }
        stk.push(new int[]{price, span});
        return span;
    }
}
