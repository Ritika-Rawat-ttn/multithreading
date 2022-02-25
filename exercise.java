// // Using join() to wait for threads to finish.


public class exercise {
    public static void main(String[] args) {
        //using Thread class
        Threadclass1 th=new Threadclass1();
        th.start();
        try{
            th.join();
        }catch (Exception ex){
            System.out.println("exceptipn");
        }


        //1 using Runnable
        new Thread(new Threadclass2()).start();




        //2 Anonymous Class
        new Thread(new Runnable(){
            public void run(){
                System.out.println("this is anonymouse class");
            }
        }).start();



        //3 Lambda
        new Thread(() -> System.out.println("this is lambda class")).start();



    }
}
class Threadclass1 extends Thread{        //extend class
    public void run(){
        for(int i=0;i<5;i++)
        {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {

                ex.printStackTrace();
            }
        }
    }

}

class Threadclass2 implements Runnable{  //Runnable class
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("implementing Runnable class" );
        }
    }
}