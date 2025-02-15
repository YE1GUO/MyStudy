package StudyThread.day2;

public class JionMethodDemo {
    public static void main (String[] args) {
        Thread t1= new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"为第一位同学服务");},"服务员一号");
        Thread t2= new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"为第二位同学服务");},"服务员二号");
        Thread t3= new Thread(()->{
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"为第三位同学服务");},"服务员三号");
        t1.start();
        t2.start();
        t3.start();
    }
}
