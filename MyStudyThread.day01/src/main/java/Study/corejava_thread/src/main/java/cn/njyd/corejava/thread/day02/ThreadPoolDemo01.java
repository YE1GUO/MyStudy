package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

import java.util.concurrent.*;

/**
 * ClassName:ThreadPoolDemo01
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 9:28
 * @Author:lixiaoming-李晓明
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(
                3,//核心线程数量
                5,//最大线程数量
                500L,//表示零时线程等待的最长时间
                TimeUnit.MILLISECONDS,//用来指定第三个参数的单位，秒，毫秒，微妙
                new ArrayBlockingQueue<>(3),//指定阻塞队列 的大小
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()//指定拒绝 策略
        );
        for(int i=1;i<=10;i++){
            final int k=i;
            pool.submit(()->{
                System.out.println(Thread.currentThread().getName()+"准备位第-"+k+"-用户服务");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"为第-"+k+"-用户服务完成");
            });
        }
        pool.shutdown();
    }
}
