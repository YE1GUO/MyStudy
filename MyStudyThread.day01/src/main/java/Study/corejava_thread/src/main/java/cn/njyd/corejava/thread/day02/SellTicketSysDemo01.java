package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:SellTicketSysDemo01
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 14:22
 * @Author:lixiaoming-李晓明
 * 判断程序是否有安全问题，两个必要条件：
 * 1.程序运行在两个或两个以上的线程环境下
 * 2.两个或两个以上的线程操作的是同一份共享的资源
 * 解决线程安全问题有多种方式：
 * 第一种：采用synchronized(监视器/锁){
 *          把可能出现线程安全的代码放在同步中即可
 *     }
 *     称为同步代码块
 * }
 */
class SellTieketThread implements Runnable{
    private int num=50;
    private Object lock=new Object();
    @Override
    public void run() {
        while(true){
            synchronized (lock){//同步代码块,任意的对象都可以充当锁，但必须确保锁的唯一性
            if(num>0){
                    System.out.println(Thread.currentThread().getName()+"买了一张票，目前还剩["+(--num)+"]张票");

            }else{
                System.out.println(Thread.currentThread().getName()+"票已售完！");
                break;
            }
            }
        }
    }
}
public class SellTicketSysDemo01 {
    public static void main(String[] args) {
        SellTieketThread sellTieketThread=new SellTieketThread();
        Thread t1=new Thread(sellTieketThread,"售票窗口-1");
        t1.start();
        Thread t2=new Thread(sellTieketThread,"售票窗口-1");
        t2.start();
        Thread t3=new Thread(sellTieketThread,"售票窗口-1");
        t3.start();
    }
}
