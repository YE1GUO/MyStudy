package StudyThread.day1;
/* * 采用实现Runnable接口方式来创建线程的步骤：
 * 1.让一个自定义类实现Runnable接口，并覆写该接口中的run()方法，
 * 想让不同的线程执行的操作写在该方法中即可
 * 2.创建自定义类对象
 * 3.用Thread类对象进行包装
 *   new Thread(Runnable 自定义类对象).start();
 */
    class RunnableTicket implements  Runnable{
       int num = 50 ;
         @Override
      public void run() {
      while(true){
          if(num>=0){
              System.out.println(Thread.currentThread().getName()+"卖了一张票还剩下["+(--num)+"]");
          }else{
              System.out.println("票已卖完");
              break;
          }
      }
    }
}
public class SecondTypeThread {
    public static void main(String[] args) {
        RunnableTicket t1 = new RunnableTicket();
        for(int i = 1;i<=4;i++){
            new Thread(t1,"第["+i+"]站").start();
        }
    }
    }
