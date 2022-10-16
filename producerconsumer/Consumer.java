import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue queue=null;

    public Consumer(BlockingQueue queue)
    {
        this.queue=queue;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
