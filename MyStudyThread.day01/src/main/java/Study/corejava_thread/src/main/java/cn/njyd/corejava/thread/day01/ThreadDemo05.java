package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

/**
 * ClassName:ThreadDemo05
 * Package:cn.njyd.corejava.thread
 * Description:
 *
 * @Date:2025/2/13 10:43
 * @Author:lixiaoming-李晓明
 */
public class ThreadDemo05 extends Thread  {
    static int num=50;
    public void run(){
        while(true){
            if(num>0){
                System.out.println(Thread.currentThread().getName()+"买了一张票,目前还剩-"+(--num)+"-张票");
            }else{
                break;
            }

        }
    }

    public static void main(String[] args) {
        ThreadDemo05 t1= new ThreadDemo05();
       t1.setName("南京南站");
       t1.start();

        ThreadDemo05 t2= new ThreadDemo05();
        t2.setName("南京北站");
        t2.start();
    }
}
