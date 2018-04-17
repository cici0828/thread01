public class HisCommunication {

    public static void main(String[] args) {
        final Bussiness bussiness = new Bussiness();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    bussiness.sub(i);
                }

            }
        }).start();

        for (int i = 0; i < 50; i++) {
            bussiness.main(i);
        }
    }

    class Bussiness{
        public synchronized void  sub(int j){
            for (int i = 0; i < 10 ; i++) {
                System.out.println("sub1:" + i + " of " + j);
            }
        }

        public  synchronized void main(int j){
            for (int i = 0; i<100; i++){
                System.out.println("main:" + i + " of " + j);
            }
        }
    }
}
