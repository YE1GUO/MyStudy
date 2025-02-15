package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName:CallableDemo02
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 14:14
 * @Author:lixiaoming-李晓明
 * 创建线程的第三种方式，采用实现Callable接口方式,步骤
 * 1.让自定义类实现Callable接口，并覆写该接口中的call方法，该方法是有返回值的，也可以抛出异常
 * 我们只要把多线程索要执行的任务代码写在该call方法中即可
 * 2.需要使用FutureTask类来进行包装
 *    FutureTask<U> (Callable<U>  第一步中的对象),FutureTask实现了Runnable接口和Future<U>接口
 *   3.在使用Thread(Runnable)构造方法来对第二步中的FutureTask来进行包装
 */
public class CallableDemo02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+" come in");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" over");
            return "hello Callable";
        });
        Thread t1=new Thread(futureTask);
        t1.start();
        System.out.println(Thread.currentThread().getName()+"处理自己的事情");
        System.out.println(futureTask.get());
    }
}
