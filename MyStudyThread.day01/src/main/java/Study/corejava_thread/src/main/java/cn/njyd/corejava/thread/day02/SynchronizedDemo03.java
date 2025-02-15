package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:SynchronizedDemo03
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 14:57
 * @Author:lixiaoming-李晓明
 */
class Lock{

}
class Ticket{
    int num=50;
    Lock lock=new Lock();

    public void sell(){
        synchronized (lock){
            if(num>0){
                System.out.println(Thread.currentThread().getName()+"卖出了一张票");
                num--;
                System.out.println("目前还剩:"+num+"张票！");
            }else{
                System.out.println(Thread.currentThread().getName()+"票已售完");
                return;
            }
        }
    }
}
public class SynchronizedDemo03 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        ExecutorService pool= Executors.newFixedThreadPool(4);
        for(int i=1;i<=100;i++){
            pool.submit(()->{
                for(int j=1;j<=10;j++){
                    ticket.sell();
                }
            });
        }
        pool.shutdown();
    }
}
