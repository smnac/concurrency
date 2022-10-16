public class CounterMain {

    public static void main(String[] args) {
        CounterSynchronized counterSynchronized = new CounterSynchronized();

        Thread t1 = new Thread(()->{
            for(int i=0;i<100;i++)
            counterSynchronized.inc();
        });

        Thread t2 = new Thread(()->{
            for(int i=0;i<100;i++)
                counterSynchronized.inc();
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(counterSynchronized.get());
    }
}
