public class CircularDoublyLinkedList {

    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        last.next = newNode;
        newNode.prev = last;
        newNode.next = head;
        head.prev = newNode;
    }

    public void delete(int key) {
        if (head == null)
            return;

        Node current = head;

        do {
            if (current.data == key) {

                if (current == head && head.next == head) {
                    head = null;
                    return;
                }

                current.prev.next = current.next;
                current.next.prev = current.prev;

                if (current == head)
                    head = head.next;

                return;
            }

            current = current.next;

        } while (current != head);
    }

    public void display() {

        if (head == null) {
            System.out.println("List Empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(Head)");
    }

    public static void main(String[] args) {

        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.display();

        list.delete(20);

        list.display();
    }
}
