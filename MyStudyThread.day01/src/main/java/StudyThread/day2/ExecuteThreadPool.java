package StudyThread.day2;

import java.util.concurrent.*;

public class ExecuteThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 6, 300,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3
        ),Executors.defaultThreadFactory() ,new ThreadPoolExecutor.AbortPolicy());
        for(int i = 1; i<=8;i++){
            final int k=i;//这个放在里外有何区别？
            pool.submit(()->{
                //final int k =i;
                System.out.println(Thread.currentThread().getName()+"准备为第["+k+"]位用户进行服务");
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }pool.shutdown();
    }
}
