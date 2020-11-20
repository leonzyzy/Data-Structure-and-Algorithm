package structure.implement.linear_structure.Queue;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        // define a object
        CircleArrayQueue q = new CircleArrayQueue(5);

        // test add
        q.addQueue(5);
        q.addQueue(3);
        q.addQueue(8);
        q.addQueue(4);

        q.showQueue();
        System.out.println("===============");
        System.out.println(q.DeQueue());
        System.out.println("===============");
        q.showQueue();
        System.out.println("===============");

        // add
        q.addQueue(10);
        q.showQueue();

    }
}

class CircleArrayQueue {
    private int maxSize; // max capacity
    private int font;  // first index of queue
    private int rear; // last index - 1 of queue
    private int[] arr; // store data and simulate queue

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];

        // two pointers
        this.font = 0;
        this.rear = 0;

    }

    // check if queue is full
    public boolean isFull() {
        return (rear + 1) % maxSize == font;
    }

    // check if empty queue
    public boolean isEmpty() {
        return rear == font;
    }

    // add data into queue
    public void addQueue(int x) {
        // check if is full
        if (isFull()) {
            System.out.println("Queue is already full");
            return;
        }
        // if not full, add data into queue
        arr[rear] = x;
        rear = (rear + 1) % maxSize;
    }

    // get data from queue
    public int DeQueue() {
        // if a empty queue
        if (isEmpty()) {
            // throw
            throw new RuntimeException("Empty queue");
        }
        // data out
        int data = arr[font];
        font = (font+1) % maxSize;

        return data;
    }

    // show queue
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        for (int i = font; i < font + getNum(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    // get number of data in queue
    public int getNum() {
        return (rear - font + maxSize) % maxSize;
    }

    // show head in queue
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        return arr[font];
    }
}




















