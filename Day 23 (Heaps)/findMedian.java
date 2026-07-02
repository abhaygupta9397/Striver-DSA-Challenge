class MedianFinder {
PriorityQueue<Integer> second;
PriorityQueue<Integer> first;
    public MedianFinder() {
        second = new PriorityQueue<>();
        first = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(first.isEmpty() || first.peek() >= num)
        {
            first.offer(num);
        }else{
            second.offer(num);
        }

        while(first.size() - 1 > second.size()){
            second.offer(first.poll());
        }

        while(second.size() > first.size()){
            first.offer(second.poll());
        }
        
    }
    
    public double findMedian() {
        if(first.size() == second.size())
        return (first.peek() + second.peek()) / 2.0 ;
        else
        return (double)first.peek();
        
    }
}

