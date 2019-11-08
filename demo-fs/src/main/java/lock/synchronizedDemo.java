package lock;

public class synchronizedDemo {

    public synchronized void A(){
        System.out.println("A");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void B(){
        System.out.println("B");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void C(){
        System.out.println("C");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        synchronizedDemo demo=new synchronizedDemo();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                demo.A();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                demo.B();
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                demo.C();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
