import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue queue=null;

    public Producer(BlockingQueue queue)
    {
        this.queue=queue;
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                queue.put(System.currentTimeMillis()+"");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
