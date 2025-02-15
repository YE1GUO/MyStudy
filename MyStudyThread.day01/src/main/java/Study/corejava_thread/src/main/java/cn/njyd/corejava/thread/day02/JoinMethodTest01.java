package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:JoinMethodTest01
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 10:05
 * @Author:lixiaoming-李晓明
 * 作业：使用join来模拟信号灯两点问题，先是绿灯，然后是黄灯，后是红灯
 */
public class JoinMethodTest01 {
    public static void main(String[] args) throws Exception{


        Thread t1=new Thread(()->{

            System.out.println(Thread.currentThread().getName()+"在南邮进行前三年的专业知识学习");
        },"同学A");
        Thread t2=new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"大四在企业做岗前培训学习");
        },"同学A");
        Thread t3=new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"进入企业工作");
        },"同学A");
        t1.start();
        t2.start();
        t3.start();
    }
}
