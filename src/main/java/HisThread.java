public class HisThread {

    public static void main(String[] args) {
        Thread thread01 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };

        thread01.start();

        Thread thread02 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });

        thread02.start();
    }
}
