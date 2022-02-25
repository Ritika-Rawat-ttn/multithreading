import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor   implements Runnable {
    private int id;


    public Processor(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("starting"+id);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){


        }
        System.out.println("completed"+id);
    }
    
}
class Processor2   implements Runnable {
    private int id;


    public Processor2(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("starting with"+id);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){


        }
        System.out.println("completed with " +id);
    }
    
}
class Processor3   implements Runnable {
    private int id;


    public Processor3(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("starting with Single :"+id);

        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){


        }
        System.out.println("completed with single :" +id);
    }
    
}


public   class Q2 {
    public static void main(String[] args) {



        /// new fixedThreadpool
        ExecutorService excutor = Executors.newFixedThreadPool(2);



        // newCachedThreadPool
        ExecutorService excutors =Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            excutor.submit(new Processor(i));
            excutors.submit(new Processor2(i));

        }
       
        excutor.shutdown();
        
    }



    // singleThreadPool
    ExecutorService executorss = Executors.newSingleThreadExecutor();
    {
        try {
            executorss.submit(new Processor3(4));
            System.out.println("Shutdown executor");
            executorss.shutdown();
            executorss.awaitTermination(5, TimeUnit.SECONDS);
         } catch (InterruptedException e) {
            System.out.println("tasks interrupted");
         } finally {
     
            if (!executorss.isTerminated()) {
               System.out.println("cancel non-finished tasks");
            }
            executorss.shutdownNow();
            System.out.println("shutdown finished");
         } 
    }
    
}
