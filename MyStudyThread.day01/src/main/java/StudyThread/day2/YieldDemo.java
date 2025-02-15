package StudyThread.day2;

public class YieldDemo {
    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "为第一位同学服务"+Thread.currentThread().getPriority());
            Thread.yield();
        }, "服务员一号");
        Thread t2 = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + "为第二位同学服务"+Thread.currentThread().getPriority());
            Thread.yield();
        }, "服务员二号");


        t1.setPriority(5);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}