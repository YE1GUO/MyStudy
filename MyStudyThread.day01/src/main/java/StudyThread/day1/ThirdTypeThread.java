package StudyThread.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* * 创建线程的第三种方式，采用实现Callable接口方式,步骤
 * 1.让自定义类实现Callable接口，并覆写该接口中的call方法，该方法是有返回值的，也可以抛出异常
 * 我们只要把多线程索要执行的任务代码写在该call方法中即可
 * 2.需要使用FutureTask类来进行包装
 *    FutureTask<U> (Callable<U>  第一步中的对象),FutureTask实现了Runnable接口和Future<U>接口
 *  3.在使用Thread(Runnable)构造方法来对第二步中的FutureTask来进行包装
 */
 class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i =0;i<=100;i++){
            sum+=i;
        }
        System.out.println(Thread.currentThread().getName()+"计算完成，sum="+sum);
        return sum;
    }
}
public class ThirdTypeThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<Integer> f1 = new FutureTask<>(new CallableDemo());
        Thread t1 = new Thread(f1,"线程-1");
        t1.start();
        System.out.println(Thread.currentThread().getName()+"在干自己的事情");
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName()+"获取计算结果"+f1.get());


    }
}
