package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName:ThreadPoolDemo02
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 16:23
 * @Author:lixiaoming-李晓明
 */
public class ThreadPoolDemo02 {
    public static void main(String[] args) {
        //创建一个可扩展的线程池对象
        ExecutorService pool= Executors.newCachedThreadPool();
        for(int i=1;i<=50;i++){
            pool.submit(()->{
                System.out.println(Thread.currentThread().getName()+" come in");
                int l= ThreadLocalRandom.current().nextInt(1000);
                try {
                    Thread.sleep(l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" come out!");
                return Thread.currentThread().getName();
            });
        }
    }
}
