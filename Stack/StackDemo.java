package Stack;
// Implement Stack ADT
// usage: Array

public class StackDemo {
    public static void main(String[] args) {
        // test.....
    }
}

class Stack {
    private int maxSize;
    private int top = -1; // ini as -1 when is empty
    private int[] stack;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // is empty method
    public boolean isEmpty() {
        return top == -1;
    }
    // is full method
    public boolean isFull() {
        return top == maxSize-1;
    }
    // push
    public void push(int value) {
        // check if is full
        if (isFull()) {
            throw new RuntimeException("Full stack");
        }
        top ++;
        stack[top] = value;
    }
    // pop
    public int pop() {
        // check if is full
        if (isFull()) {
            throw new RuntimeException("Empty stack");
        }
        // pop the top value
        int value = stack[top];
        top --;
        return value;
    }
}