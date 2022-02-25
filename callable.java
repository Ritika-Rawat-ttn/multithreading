//**Difference Between Callable and Runnable is that in callable we have reuturn method,
 //whereas in Runnable method run method is used for calling method 
 //and also We can create thread by passing runnable as a parameter but in callable we can't.**





import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Threadclass2 implements Runnable{                         //Runnable method 
    public void run(){System.out.println("here1");} 
}



public class callable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        

        executorService.submit(() -> {                                 //callable method
            System.out.println("Calling Method with lambda ");
            Thread.sleep(500);
            return 5;
        });
      
        new Thread(new Threadclass2()).start();

    }
}