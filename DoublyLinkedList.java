public class DoublyLinkedList {

    class Node {

        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    Node head = null;

    public void insertEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    public void delete(int key) {

        if (head == null)
            return;

        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null)
            return;

        if (temp == head) {
            head = head.next;

            if (head != null)
                head.prev = null;

            return;
        }

        if (temp.next != null)
            temp.next.prev = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;
    }

    public void displayForward() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertEnd(100);
        list.insertEnd(200);
        list.insertEnd(300);
        list.insertEnd(400);

        list.displayForward();

        list.delete(300);

        list.displayForward();
    }
}
