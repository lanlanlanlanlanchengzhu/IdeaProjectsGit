import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * wait notify 用来实现线程间通信
 */
public class ProducerConsumerWithBlockingQueue {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {

        ProducerConsumerWithBlockingQueue producerConsumer = new ProducerConsumerWithBlockingQueue();

        Producer producer = producerConsumer.new Producer();
        Consumer consumer = producerConsumer.new Consumer();

        producer.start();
        consumer.start();

    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("pool one element. remaining size:" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("offer one element. queue size:" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
