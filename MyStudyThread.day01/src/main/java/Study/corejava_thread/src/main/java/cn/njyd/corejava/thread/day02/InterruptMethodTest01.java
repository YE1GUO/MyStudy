package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:InterruptMethodTest01
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 11:31
 * @Author:lixiaoming-李晓明
 */
public class InterruptMethodTest01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"开始执行了");
//            while(true){
//                if(Thread.currentThread().isInterrupted()){
//                    break;
//                }
//                System.out.println(Thread.currentThread().getName()+"正在运行中------"+Thread.currentThread().isInterrupted());
//            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        Thread.sleep(1000);
        //t1.interrupted();
        t1.interrupt();
    }

}
