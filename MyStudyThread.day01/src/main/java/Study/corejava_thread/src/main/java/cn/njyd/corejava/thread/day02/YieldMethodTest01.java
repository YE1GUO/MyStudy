package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:YieldMethodTest01
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 10:27
 * @Author:lixiaoming-李晓明
 */

public class YieldMethodTest01 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"正在看第["+i+"]个视频,当前线程的优先级为："+Thread.currentThread().getPriority());
                Thread.yield();
            }
        },"同学A");
        Thread t2=new Thread(()->{
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+"正在写第-"+i+"-个程序代码,当前线程的优先级为"+Thread.currentThread().getPriority());
                Thread.yield();
            }
        });
        t1.start();
        t2.start();
    }
}
