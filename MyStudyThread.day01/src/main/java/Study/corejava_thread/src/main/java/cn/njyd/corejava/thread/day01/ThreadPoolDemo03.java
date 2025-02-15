package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:ThreadPoolDemo03
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 16:27
 * @Author:lixiaoming-李晓明
 */
class SellTicketThread implements Callable<Integer>{

    private int num=50;
    @Override
    public Integer call() throws Exception {
        while(true){
            if(num>0){
                num--;
                System.out.println(Thread.currentThread().getName()+"网点售卖了一张票,目前还剩["+num+"]张票");
            }else{
                System.out.println(Thread.currentThread().getName()+"网点的票已售完！");
                break;
            }
        }
        return null;
    }
}
public class ThreadPoolDemo03 {
    public static void main(String[] args) {
        //创建一个只有1个线程的线程池对象
       // ExecutorService pool= Executors.newSingleThreadExecutor();
        ExecutorService pool=Executors.newFixedThreadPool(3);
        SellTicketThread sellTicketThread=new SellTicketThread();
        for(int i=1;i<=10;i++){
            pool.submit(sellTicketThread);
        }
        pool.shutdown();
    }
}
