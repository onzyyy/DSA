public class LinkedListFIFOQueue {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front = null;
    Node rear = null;

    public void enqueue(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {

        if (front == null) {
            System.out.println("Queue Empty");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return value;
    }

    public int peek() {

        if (front == null)
            return -1;

        return front.data;
    }

    public void display() {

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();

        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);

        queue.display();

        System.out.println("Removed : " + queue.dequeue());

        queue.display();
    }
}
