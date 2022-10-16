public class CounterSynchronized {

    private long count = 0;

    public CounterSynchronized()
    {

    }

    public   void inc()
    {
        System.out.println(Thread.currentThread().getName()+" executing !!");
        for(int i=0;i<10;i++)
        count++;
    }

    public  long get()
    {
        return count;
    }
}
