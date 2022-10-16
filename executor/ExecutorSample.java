import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorSample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        //ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
          List<Callable<String>> callables = new ArrayList<>();
         // List<Future<String>> futures = new ArrayList<>();
          for(int i=0;i<10;i++)
          {
              callables.add(newCallable(i));

              //executorService2.execute(newRunnable(i));
              //futures.add(executorService2.submit(newCallable(i)));
          }

          List<Future<String>> futures = executorService2.invokeAll(callables);
        System.out.println(futures.get(6).get());

       /* for(int i=0;i<10;i++) {
            try {
                System.out.println((String)futures.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/
        executorService2.shutdown();

    }

    private static Callable<String> newCallable(int id) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName()+" task no : "+id;
            }
        };
    }

    private static Runnable newRunnable(int id) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" task no : "+id);
            }
        };
    }
}
