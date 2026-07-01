public class TestGenericQueue {
    public static void main(String[] args) {

        GenericQueue<String> queue = new GenericQueue<>();

        System.out.println("Queue: " + queue);

        queue.enqueue("Tom");
        queue.enqueue("George");
        queue.enqueue("Peter");

        System.out.println("After enqueue:");
        System.out.println(queue);

        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Queue after dequeue:");
        System.out.println(queue);

        queue.enqueue("Jane");

        System.out.println("After enqueue Jane:");
        System.out.println(queue);

        System.out.println("Front element: " + queue.getFront());
    }
}