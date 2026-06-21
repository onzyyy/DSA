import java.util.*;

class QueueStackPushFriendly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int data) {
        q1.add(data);
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int value = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return value;
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
