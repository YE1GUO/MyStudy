package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

/**
 * ClassName:ThreadDemo04
 * Package:cn.njyd.corejava.thread
 * Description:
 *
 * @Date:2025/2/13 10:35
 * @Author:lixiaoming-李晓明
 */
public class ThreadDemo04 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for(int i=1;i<=50;i++){
                System.out.println(Thread.currentThread().getName()+"-"+i+"-");
            }
        },"t1线程");
        t1.start();
//        for(int i=1;i<=50;i++){
//            System.out.println(Thread.currentThread().getName()+"-"+i+"");
//        }
        new Thread(new Runnable(){

            @Override
            public void run() {
                for(int i=1;i<=50;i++){
                    System.out.println(Thread.currentThread().getName()+"-"+i+"");
                }
            }
        },"t2线程").start();
    }
}
