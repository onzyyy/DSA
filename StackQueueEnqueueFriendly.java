import java.util.*;

class StackQueueEnqueueFriendly {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data) {
        s1.push(data);
    }

    public int dequeue() {

        if (s1.isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }

        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        int value = s1.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return value;
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
