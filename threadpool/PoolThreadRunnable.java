import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{
    private Thread thread=null;
    private BlockingQueue taskQueue=null;
    private boolean isStopped=false;

    public PoolThreadRunnable(BlockingQueue queue)
    {
        taskQueue=queue;
    }

    public void run()
    {
        this.thread=Thread.currentThread();
        while(!isStopped())
        {
            try
            {
                Runnable runnable = (Runnable)taskQueue.take();  //it will be blocked/hanging here, call interrupt to take it out
                runnable.run();
            } catch(Exception e)
            {
                System.out.println("ayyo interruption !!");
            }
        }

    }

    public synchronized void doStop()
    {
        isStopped=true;
        this.thread.interrupt();
    }

    public synchronized  boolean isStopped()
    {
        return isStopped;
    }

}
