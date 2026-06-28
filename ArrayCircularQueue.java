public class ArrayCircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data) {

        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;

        System.out.println(data + " inserted");
    }

    public int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = queue[front];
        front = (front + 1) % capacity;
        size--;

        return value;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Queue : ");

        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        ArrayCircularQueue q = new ArrayCircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();

        System.out.println("Removed : " + q.dequeue());

        q.display();
    }
}
