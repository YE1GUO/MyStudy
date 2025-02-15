package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName:ThreadPoolDemo01
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 16:15
 * @Author:lixiaoming-李晓明
 */
public class ThreadPoolDemo01 {
    public static void main(String[] args) {

        //通过工具类来创建一个具有固定大小的线程池对象
        ExecutorService pool= Executors.newFixedThreadPool(3);
        for(int i=1;i<=10;i++){
            pool.execute(()->{
                System.out.println(Thread.currentThread().getName()+" come in");
                int l= ThreadLocalRandom.current().nextInt(1000);
                try {
                    Thread.sleep(l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" come out!");
            });
        }
        pool.shutdown();//不要忘记释放线程池资源.
    }
}
