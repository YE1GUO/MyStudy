package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:SynchronizedDemo02
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 14:46
 * @Author:lixiaoming-李晓明
 */
class Account{
    private String id;
    private int balance=1000;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * 采用同步方法
     * 对于实例方法默认采用的是this锁，对于static静态方法（也称为类方法）默认采用的是当前类的二进制字节码文件作为锁对象
     * @param money
     */
    public  synchronized void  withDraw(int money){//取款操作
        if(this.balance-money<0){
            System.out.println(Thread.currentThread().getName()+"企图对账户"+id+"取款操作失败，原因是余额不足");
            return;
        }
        this.balance-=money;
        System.out.println(Thread.currentThread().getName()+"对账户"+id+"进行了取款操作，取款"+money+"后余额为："+this.balance);
    }
}
public class SynchronizedDemo02 {
    public static void main(String[] args) {
        Account account=new Account();
        for(int i=1;i<=100;i++){
            Thread t1=new Thread(()->{
                account.withDraw(100);
            },"ATM-"+i);
            t1.start();
        }

    }
}
