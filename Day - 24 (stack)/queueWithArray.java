class myQueue {

    int arr[];
    int front;
    int rear;
    int n;

    public myQueue(int n) {
        arr = new int[n];
        front = -1;
        rear = -1;
        this.n = n;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % n == front;
    }

    public void enqueue(int x) {

        if (isFull())
            return;

        // First element
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % n;
        }

        arr[rear] = x;
    }

    public void dequeue() {

        if (isEmpty())
            return;

        // Only one element
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % n;
        }
    }

    public int getFront() {

        if (isEmpty())
            return -1;

        return arr[front];
    }

    public int getRear() {

        if (isEmpty())
            return -1;

        return arr[rear];
    }
}
