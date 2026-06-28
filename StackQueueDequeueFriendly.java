import java.util.Stack;

public class StackQueueDequeueFriendly {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue (O(n))
    public void enqueue(int data) {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        s1.push(data);

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue (O(1))
    public int dequeue() {

        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        return s1.pop();
    }

    public void display() {
        System.out.println(s1);
    }

    public static void main(String[] args) {

        StackQueueDequeueFriendly queue = new StackQueueDequeueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued : " + queue.dequeue());

        queue.display();
    }
}
