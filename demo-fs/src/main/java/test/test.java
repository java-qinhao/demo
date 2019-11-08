package test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Date;
import java.util.Hashtable;
import java.util.Timer;
import java.util.concurrent.*;

public class test {
//    public static void main(String[] args) {
//        int[] arr=new int[1000];
//        for(int i=0;i<1000;i++){
//            arr[i]=i;
//        }
//        int re=test.BinarySearch(arr,arr.length,500);
//        System.out.println(re);
//    }
//
//    public static int BinarySearch(int a[],int size,int p)
//    {
//        int L=0;//查找区间的左端点
//        int R=size-1;//查找区间的右端点
//        while(L<=R)//如果区间不为空就继续查找
//        {
//            int mid=L+(R-L)/2;//取查找区间正中元素的下标
//            if(p==a[mid])
//                return mid;
//            else if(p>a[mid])
//                L=mid+1;//设置新的查找区间的左端点
//            else
//                R=mid-1;//设置新的查找区间的右端点
//        }
//        return -1;
//    }

    static int num=0;
    public static void main(String[] args) throws Exception{
//        ExecutorService executorService= Executors.newCachedThreadPool();
//
//        for (int i = 0; i <2; i++) {
//            final int j=i;
//            executorService.execute(new Runnable() {
//                public void run() {
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(j+" "+ Thread.currentThread().getName());
//                }
//            });
//        }
//        Thread.sleep(500);
//        executorService.execute(new Runnable() {
//            public void run() {
//                System.out.println(" "+ Thread.currentThread().getName());
//            }
//        });
//        ExecutorService executorService=Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(new Runnable() {
//                public void run() {
//                    try {
//                        num++;
//                        Thread.sleep(2000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(num);
//                }
//            });
//        }
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
//        executorService.scheduleAtFixedRate(new Runnable() {
//            public void run() {
//                System.out.println(new Date());
//            }
//        },1,1, TimeUnit.SECONDS);
//        Timer agentlevelTotalTime = new Timer();
    }
}
