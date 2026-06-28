public class LinkedListStack {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;

    public void push(int data) {

        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;
    }

    public int pop() {

        if (top == null) {
            System.out.println("Stack Empty");
            return -1;
        }

        int value = top.data;
        top = top.next;

        return value;
    }

    public int peek() {

        if (top == null)
            return -1;

        return top.data;
    }

    public void display() {

        Node temp = top;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(100);
        stack.push(200);
        stack.push(300);

        stack.display();

        System.out.println("Pop : " + stack.pop());

        stack.display();
    }
}
