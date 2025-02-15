package Study.corejava_thread.src.main.java.cn.njyd.corejava.thread.day02;

/**
 * ClassName:JoinMethodTest02
 * Package:cn.njyd.corejava.thread.day02
 * Description:
 *
 * @Date:2025/2/14 10:15
 * @Author:lixiaoming-李晓明
 */
public class JoinMethodTest02 {
    public static void main(String[] args) {
        Thread greenLight=new Thread(()->{

            for(int i=1;i<=10;i++){
                System.out.print("绿灯亮了：");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(i+"-");
            }
            System.out.println();
        });

        Thread yellowLight=new Thread(()->{
            try {
                greenLight.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i=1;i<=3;i++){
                System.out.print("黄灯亮了：");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(i+"-");
            }
            System.out.println();
        });
        Thread redLight=new Thread(()->{
            try {
                yellowLight.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(int i=1;i<=5;i++){
                System.out.print("红灯亮了：");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print(i+"-");
            }
            System.out.println();
        });
        redLight.start();
        greenLight.start();
        yellowLight.start();
    }
}
