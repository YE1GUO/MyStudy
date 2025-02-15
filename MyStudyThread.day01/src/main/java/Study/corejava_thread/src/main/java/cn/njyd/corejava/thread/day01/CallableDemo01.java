package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:CallableDemo01
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 14:06
 * @Author:lixiaoming-李晓明
 */
class CallableTest01 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for(int i=1;i<=100;i++){
            sum+=i;
        }
        System.out.println(Thread.currentThread().getName()+"计算完成，sum="+sum);
        return sum;
    }
}

public class CallableDemo01 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CallableTest01 ct=new CallableTest01();
        FutureTask<Integer> futureTask=new FutureTask<>(ct);
        Thread thread=new Thread(futureTask,"线程-1");
        thread.start();
        System.out.println(Thread.currentThread().getName()+"在干自己的事情");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName()+",获取计算结果："+futureTask.get());
    }
}
