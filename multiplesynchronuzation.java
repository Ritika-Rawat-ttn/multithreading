public class multiplesynchronuzation {
    private static Integer I1=0;
    private static Integer I2 =0;
    private static Object lock1 =new Object();
    private static Object lock2 =new Object();
    

    private synchronized void increment() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+"Incrementing");
        synchronized(lock1){
            I1++;
        }
        System.out.println(Thread.currentThread().getName()+"Incrementing");

    }
    private synchronized void  decrement() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+"decrementing");
        synchronized(lock2){
            I2--;
        }
        System.out.println(Thread.currentThread().getName()+"decrementing");


    }
    public static void main(String[] args) throws InterruptedException {
        multiplesynchronuzation multiplesync =new multiplesynchronuzation();
        Thread t1 =new Thread(() -> {
            for (int i=0;i<500;i++) {
                try{
                    multiplesync.increment();}
                    catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    
                }
            },"INCREMENT1");
        Thread t2 =new Thread(() -> {
                for (int i=0;i<500;i++) {
                    try{
                        multiplesync.decrement();}
                        catch(InterruptedException ex){
                            ex.printStackTrace();
                        }
                        
                    }
                },"DECREMENT1");
        Thread t3 =new Thread(() -> {
                    for (int i=0;i<500;i++) {
                        try{
                            multiplesync.increment();}
                            catch(InterruptedException ex){
                                ex.printStackTrace();
                            }
                            
                        }
                    },"INCREMENT2");
        Thread t4 =new Thread(() -> {
                        for (int i=0;i<500;i++) {
                            try{
                                multiplesync.decrement();}
                                catch(InterruptedException ex){
                                    ex.printStackTrace();
                                }
                                
                            }
                        },"DECREMENT2");
                        t1.start();
                        t2.start();
                        t3.start();
                        t4.start();
                        t1.join();
                        t2.join();
                        t3.join();
                        t4.join();
                        System.out.println("Final Value of Integer: " +I1);
                        System.out.println("Final Value of Integer: " + I2);

            
        
    

        
    }


    
}
