package StudyThread.day1;

/* * 创建线程的第一种方式：
 * 采用继承Thread类方式,步骤：
 * 1.让自定义类继承Thread
 * 2.覆写Thread类中的run()方法，我们把想让多线程执行的代码写在此方法中即可
 * 3.创建自定义线程对象，并调用其start()方法来启动线程
 */
class Ticket {
    private int num ;
    private String start;
    private String end;

    @Override
    public String toString() {
        return "Ticket{" +
                "num=" + num +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Ticket(int num, String start, String end) {
        this.num = num;
        this.start = start;
        this.end = end;
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



}

class TicketThread extends Thread{
     private  Ticket ticket ;
    public TicketThread(Ticket ticket,String name) {
        super(name);
        this.ticket = ticket;
    }

    public TicketThread(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public void run() {
     while(true){
         if(ticket.getNum()>=0){
             ticket.setNum(ticket.getNum()-1);
             System.out.println(Thread.currentThread().getName()+"卖出一张票["+ticket.getNum()+"]");
             //由于这里是继承了thread对象，可以用this.getName（）这是Thread类的第一个方法获得线程名字。
         }else {
             System.out.println("票已卖完");break;
         }
     }
    }
}
public class FirstTypeThread{
    public static void main(String[] args) {
       Ticket ticket = new Ticket(30,"南京","上海");
       TicketThread t1 = new TicketThread(ticket,"南京北站");
       TicketThread t2 = new TicketThread(ticket,"北京北站");
       TicketThread t3 = new TicketThread(ticket);
       t3.setName("山东站");
       t1.start();
       t2.start();
       t3.start();
    }
}
