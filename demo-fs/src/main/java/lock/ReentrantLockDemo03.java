package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo03 implements Runnable  {

    private ReentrantLock lock = new ReentrantLock();

    public void run() {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " 获取当前lock锁");
                TimeUnit.SECONDS.sleep(2);
            } else {
                System.out.println(Thread.currentThread().getName()+ " 获取锁失败");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        ReentrantLockDemo03 reentrantLockDemo = new ReentrantLockDemo03();
        Thread thread01 = new Thread(reentrantLockDemo, "thread01");
        Thread thread02 = new Thread(reentrantLockDemo, "thread02");
        thread01.start();
        thread02.start();
    }
}
