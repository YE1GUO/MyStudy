package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:ThreadPoolDemo04
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 16:35
 * @Author:lixiaoming-李晓明
 * scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
 * 创建并执行在给定的初始延迟之后首先启用的定期动作，随后在一个执行的终止和下一个执行的开始之间给定的延迟。
 *
 * scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
 * 创建并执行在给定的初始延迟之后，随后以给定的时间段首先启用的周期性动作; 那就是执行将在initialDelay之后开始，然后是initialDelay+period ，然后是initialDelay + 2 * period ，等等。
 */
public class ThreadPoolDemo04 {
    public static void main(String[] args) {

        final ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
//        pool.scheduleWithFixedDelay(()->{
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("氢弹爆炸了!");
//        },1,1, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(()->{
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+"开始起爆！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },1,1,TimeUnit.SECONDS);
        //pool.shutdown();
    }
}
