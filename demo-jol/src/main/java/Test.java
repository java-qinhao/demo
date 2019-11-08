import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test {
    static Test a;
    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        a=new Test();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        synchronized (a){
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
        Thread.sleep(2000);

        List<Thread> list=new ArrayList<Thread>();
        for(int i=0;i<1;i++){
            Thread th=new Thread(){
                @Override
                public void run() {
                    synchronized (a){
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                }
            };
            th.start();
        }
        Thread.sleep(2000);
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }
}
