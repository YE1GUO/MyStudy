package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ClassName:CallableDmeo04
 * Package:cn.njyd.corejava.thread.day01
 * Description:
 *
 * @Date:2025/2/13 15:05
 * @Author:lixiaoming-李晓明
 */
class BankAccount{
    private String cardNo;
    private Integer balance;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public BankAccount(String cardNo, Integer balance) {
        this.cardNo = cardNo;
        this.balance = balance;
    }
    public void deposit(int money){//存款业务
        this.balance+=money;
        System.out.println(Thread.currentThread().getName()+"从账号["+this.cardNo+"]存了-"+money+"-元");
    }
    public void withDraw(int money){//取款业务
        if(this.balance-money<0){
            System.out.println("余额不足，取款失败！");
            return;
        }
        this.balance-=money;
        System.out.println(Thread.currentThread().getName()+"从账号["+this.cardNo+"]取了"+money+"元====");
    }
}
class BankCallable implements Callable<Integer>{
    private BankAccount bankAccount;
    public BankCallable(BankAccount bankAccount){
        this.bankAccount=bankAccount;
    }
    @Override
    public Integer call() throws Exception {
        //获取一个随机数
        int n= ThreadLocalRandom.current().nextInt(10);
        System.out.println("n="+n);
        if(n%2==0){
            for(int i=1;i<=n;i++){
                this.bankAccount.deposit(100);
            }
        }else{
            for(int i=1;i<=n;i++){
                this.bankAccount.withDraw(50);
            }
        }
        return this.bankAccount.getBalance();
    }
}
public class CallableDmeo04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BankCallable bankCallable=new BankCallable(new BankAccount("888888",500));
        FutureTask<Integer> ft1=new FutureTask<>(bankCallable);
        for(int i=1;i<=5;i++){//模拟5个银行窗口
            new Thread(new FutureTask<>(bankCallable)).start();
        }

        //System.out.println(ft1.get());
    }
}
