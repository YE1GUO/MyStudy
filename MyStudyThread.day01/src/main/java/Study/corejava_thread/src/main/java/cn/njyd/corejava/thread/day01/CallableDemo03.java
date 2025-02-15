package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName:CallableDemo03
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 14:26
 * @Author:lixiaoming-李晓明
 */
class TicketCallable implements Callable<Integer>{
    int num=50;
    public Integer call()throws Exception{
        while(true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了一张票，目前还剩[" + (--num) + "]张票");
            } else {
                System.out.println(Thread.currentThread().getName()+"票已售完！");
                break;
            }
        }
        return num;
    }
}
public class CallableDemo03 {
    public static void main(String[] args) {
        TicketCallable ticketCallable=new TicketCallable();

        for(int i=1;i<=4;i++){
          new Thread(
                  new FutureTask<>(ticketCallable),
                  "售票窗口-"+i)
                  .start();
        }
    }
}
