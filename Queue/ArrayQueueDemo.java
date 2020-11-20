package structure.implement.linear_structure.Queue;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        // define a queue object
        ArrayQueue arrayQueue = new ArrayQueue(5);

        // test is empty
        System.out.println(arrayQueue.isEmpty()); // true

        // test add queue
        System.out.println("========After insert data=====");
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(8);
        arrayQueue.addQueue(4);
        arrayQueue.addQueue(1);
        arrayQueue.showQueue();

        // test dequeue
        System.out.println("========After out data=====");
        System.out.println("The out is " + arrayQueue.DeQueue());


        // test get head queue
        System.out.println("The head data is " + arrayQueue.headQueue());

        // test is full
        System.out.println(arrayQueue.isFull());

    }

}

// define a ArrayQueue class
class ArrayQueue {
    private int maxSize; // max capacity
    private int font;  // font of queue
    private int rear; // rear of queue
    private int[] arr; // store data and simulate queue

    // define a queue constructor
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];

        // two pointers
        this.font = -1;
        this.rear = -1;
    }

    // check if queue is full
    public boolean isFull() {
        return rear == maxSize-1;
    }

    // check if empty queue
    public boolean isEmpty() {
        return rear == font;
    }

    // add data into queue
    public void addQueue(int x) {
        // check is queue already full
        if (isFull()) {
            System.out.println("Queue is already full");
            return;
        }
        rear++;
        arr[rear] = x;
    }

    // get data from queue
    public int DeQueue() {
        if (isEmpty()) {
            // throw
            throw new RuntimeException("Empty queue");
        }
        font++;
        return arr[font];

    }

    // show head in queue
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue");
        }
        return arr[font+1];
    }

    // show queue
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i, arr[i]);
        }
    }
}













