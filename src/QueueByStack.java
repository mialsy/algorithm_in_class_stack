import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class QueueByStack {
    private Deque<Integer> stackStore = new ArrayDeque();
    private Deque<Integer> stackInitalEntry = new ArrayDeque();

    // O(1) for enqueue
    public void enqueue(int elem) {
        stackInitalEntry.push(elem);
    }

    // O(n) because of move
    public int dequeue() {
        if (stackStore.isEmpty()) {
            move();
        }
//        if (stackStore.isEmpty()) {
//            throw new NullPointerException();
//        }
        return stackStore.pop();
    }

    // O(n) to move
    private void move() {
        while (!stackInitalEntry.isEmpty()) {
            stackStore.push(stackInitalEntry.pop());
        }
    }

    // O(1)
    public boolean isEmpty() {
        // or return (stackStore.size() + stackStore.size()) == 0
        return stackStore.isEmpty() && stackInitalEntry.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack queue = new QueueByStack();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.dequeue());
        System.out.println(queue.isEmpty());
        try {
            System.out.println(queue.dequeue());
        } catch (NoSuchElementException e) {
            System.out.println("catch no such element exception");
        }
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
