package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:CallableDemo05
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 15:22
 * @Author:lixiaoming-李晓明
 */
public class CallableDemo05 {
    public static void main(String[] args) {
        Thread t1=new Thread(new FutureTask<String>(()->{
            for(int i=1;i<=10;i++){
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName()+"正在看第-"+i+"-个视频学习");
            }
            return Thread.currentThread().getName();
        }),"学生A");
        Thread t2=new Thread(new FutureTask<String>(()->{
            for(int i=1;i<=10;i++){
                TimeUnit.MICROSECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName()+"正在写第-"+i+"-个程序的代码");
            }
            return Thread.currentThread().getName();
        }),"学生B");
        t1.start();
        t2.start();

    }
}
