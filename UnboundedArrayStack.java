class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int data) {
        if (top + 1 == capacity) {
            resize(capacity * 2);
        }

        stack[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Empty");
            return -1;
        }

        int value = stack[top--];

        if (top + 1 > 0 && top + 1 == capacity / 4) {
            resize(capacity / 2);
        }

        return value;
    }

    private void resize(int newSize) {
        int[] temp = new int[newSize];

        for (int i = 0; i <= top; i++) {
            temp[i] = stack[i];
        }

        stack = temp;
        capacity = newSize;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
