package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:DaemonThread
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 10:35
 * @Author:lixiaoming-李晓明
 * 线程分为两类：用户线程和守护线程（也成为后台线程）
 */
public class DaemonThread {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
           while(true){
               System.out.println(Thread.currentThread().getName()+"在运行");
           }
        });
        t1.setDaemon(true);//把该用户线程设置为守护线程,该设置方法调用语句必须要出现在start()启动之前
        t1.start();
        for(int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"也在运行"+i);
        }
    }
}
