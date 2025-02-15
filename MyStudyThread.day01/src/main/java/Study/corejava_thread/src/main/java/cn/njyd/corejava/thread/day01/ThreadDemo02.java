package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

/**
 * ClassName:ThreadDemo02
 * Package:cn.njyd.corejava.thread
 * Description:
 *
 * @Date:2025/2/13 10:17
 * @Author:lixiaoming-李晓明
 */
class StudyThread extends Thread{
    public StudyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
       int n=(int)(Math.random()*100);
       // System.out.println(n);
       if(n%2==0){
           System.out.println(Thread.currentThread().getName()+"正在看视频学习CoreJava");
       }else{
           System.out.println(this.getName()+"正在写代码学习-----");
       }
    }
}
public class ThreadDemo02 {
    public static void main(String[] args) {
        for(int n=1;n<=50;n++){
            new StudyThread("第["+n+"]位同学").start();
        }
    }
}
