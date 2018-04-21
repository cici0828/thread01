import java.util.Random;

public class ThreadLocalTest01 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    public static void main(String[] args) {
        for(int i=0; i<2; i++){
            new Thread(new Runnable() {
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(data);
                    threadLocal.set(data);
                    new A().getA();
                    new B().getB();
                }
            }).start();
        }
    }

    static class A{
        public void getA(){
            int data = threadLocal.get();
            System.out.println("A from " + Thread.currentThread().getName() + ":" + data);
        }
    }

    static class B{
        public void getB(){
            int data = threadLocal.get();
            System.out.println("B from " +Thread.currentThread().getName() + ":" + data);
        }
    }

}
