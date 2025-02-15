package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

/**
 * ClassName:ThreadDemo03
 * Package:cn.njyd.corejava.thread
 * Description:
 *
 * @Date:2025/2/13 10:29
 * @Author:lixiaoming-李晓明
 * 采用实现Runnable接口方式来创建线程的步骤：
 * 1.让一个自定义类实现Runnable接口，并覆写该接口中的run()方法，
 * 想让不同的线程执行的操作写在该方法中即可
 * 2.创建自定义类对象
 * 3.用Thread类对象进行包装
 *   new Thread(Runnable 自定义类对象).start();
 */
class TicketRunnable implements Runnable{
    int num=50;
    @Override
    public void run() {
        while(true){
            if(num>0){
                System.out.println(Thread.currentThread().getName()+"售卖了一张票，目前还剩["+(--num)+"]张票！");
            }else{
                System.out.println(Thread.currentThread().getName()+"占点票已售完！");
                break;
            }

        }
    }
}
public class ThreadDemo03 {
    public static void main(String[] args) {
        TicketRunnable tr=new TicketRunnable();
        Thread t1=new Thread(tr,"南京南站");
        t1.start();
        Thread t2=new Thread(tr,"南京北站");
        t2.start();
        new Thread(tr,"南京西站").start();
    }
}
