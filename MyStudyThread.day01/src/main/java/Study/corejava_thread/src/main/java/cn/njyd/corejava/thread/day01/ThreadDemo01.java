package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;


/**
 * ClassName:ThreadDemo01
 * Package:cn.njyd.corejava.thread
 * Description:
 *
 * @Date:2025/2/13 9:27
 * @Author:lixiaoming-李晓明
 * 创建线程的第一种方式：
 * 采用继承Thread类方式,步骤：
 * 1.让自定义类继承Thread
 * 2.覆写Thread类中的run()方法，我们把想让多线程执行的代码写在此方法中即可
 * 3.创建自定义线程对象，并调用其start()方法来启动线程
 */
class Ticket{
    private int num=50;
    private String start;
    private String end;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Ticket() {
    }

    public Ticket(int num, String start, String end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "num=" + num +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
class TicketThread extends Thread{
    private Ticket ticket;
    public TicketThread(Ticket ticket,String name){
        super(name);
        this.ticket=ticket;
    }
    public TicketThread(Ticket ticket){
        this.ticket=ticket;
    }
    @Override
    public void run() {
        while(true){
            if(ticket.getNum()>0){
                ticket.setNum(ticket.getNum()-1);
                System.out.println(this.getName()+"站点买了一张票，目前还剩["+ticket.getNum()+"]张票");
            }else{
                System.out.println("票已买完!");
                 break;
            }
        }
    }
}
public class ThreadDemo01 {
    public static void main(String[] args) {
        //创建一个资源类
        Ticket ticket=new Ticket(100,"南京","上海");
        //创建三个线程对象
        TicketThread t1=new TicketThread(ticket,"南京南站");
        TicketThread t2=new TicketThread(ticket,"南京小红山");
        TicketThread t3=new TicketThread(ticket);
        t3.setName("南京北站");
        //启动线程,不能直接调用线程的run方法来启动线程
        t1.start();//该方法也只能被调用一次
        t2.start();
        t3.start();
        //t3.start();
    }
}
