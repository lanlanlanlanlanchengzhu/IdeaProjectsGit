import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * wait notify 用来实现线程间通信
 */
public class ProducerConsumer {

    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer();

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
                synchronized (queue) {
                    while (queue.size() == 0) {
                        try {
                            System.out.println("queue is empty. wait");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("pool one element. remaining size:" + queue.size());
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
                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("queue is full. wait");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                    queue.offer(1); // insert one element
                    queue.notify();
                    System.out.println("offer one element. queue size:" + queue.size());
                }
            }
        }
    }

}
