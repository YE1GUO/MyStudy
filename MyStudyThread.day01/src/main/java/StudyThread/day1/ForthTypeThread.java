package StudyThread.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ForthTypeThread {
    public static void main(String[] args) {
       /* ExecutorService pool = Executors.newFixedThreadPool(3);
        for(int i =1; i<=3;i++){
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+"启动");
                int l = ThreadLocalRandom.current().nextInt(100);
                        try {
                            Thread.sleep(l);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                System.out.println(Thread.currentThread().getName()+"结束");
                    });
        }pool.shutdown();
        此处是建立一个固定大小的线程池，使用execute方法注入线程，它需要传入一个Runnable对象*/

        /*ExecutorService pool = Executors.newCachedThreadPool();
            for(int i = 1; i <= 50;i++){
             pool.submit(()->{
                System.out.println(Thread.currentThread().getName()+"启动");
                int l = ThreadLocalRandom.current().nextInt(100);
                try {
                    Thread.sleep(l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"结束");
            });
            };
            这是第二种线程池，利用Execute.newCashedThreadPool();来创建可变线程池，然后submit方法注入Runnable对象
            */
         ExecutorService pool = Executors.newFixedThreadPool(4);
         SellTicket sr = new SellTicket();
         for(int i = 1; i <= 10;i++) {
             //这里一步有问题以至于我出错！！这里每次多线程传入的时候都是重新创建对象，这样是错的应该使用同一个对象 pool.submit(new SellTicket());
             pool.submit(sr);
         }
         pool.shutdown();
        }
    }
   class SellTicket implements Callable<Integer>{
      private int num = 50;
       @Override
       public Integer call() throws Exception {
          while (true){
              if(num>0){
                  num--;
                  System.out.println(Thread.currentThread().getName()+"票卖出一张，还剩["+num+"]张票");
              }else {System.out.println("票已卖完");
                  break;}
          }
           return null;
       }
   }

