import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped=false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks)
    {
        taskQueue= new ArrayBlockingQueue(maxNoOfTasks);

        for(int i=0;i<noOfThreads;i++)
        {
            PoolThreadRunnable runnable = new PoolThreadRunnable(taskQueue);
            runnables.add(runnable);
            new Thread(runnable).start();
        }
    }

    public synchronized  void execute(Runnable task)
    {
        if(this.isStopped)
            throw new IllegalStateException("Thread pool is stopped !!");
        taskQueue.offer(task);

    }

    public synchronized void stop()
    {
        this.isStopped=true;
        for(PoolThreadRunnable runnable:runnables)
            runnable.doStop();
    }

    public synchronized void waitUntilAllTaskFinished()
    {
        while(taskQueue.size()>0)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
