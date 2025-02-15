package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:SuspundResumeMethodDemo01
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 11:17
 * @Author:lixiaoming-李晓明
 */
class MyThread implements Runnable{
    private int i=0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while(true){
            i++;
        }
    }
}
public class SuspundResumeMethodDemo01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
       Thread t=new Thread(myThread);
       t.start();
       Thread.sleep(2000);
      // t.suspend();
    }
}
