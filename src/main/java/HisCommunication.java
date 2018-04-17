public class HisCommunication {

    public static void main(String[] args) {
        new HisCommunication().init();

    }

    public void init(){
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

    private  class Bussiness{
        private boolean bShouldSub = true;

        public synchronized void  sub(int j) {
            while (!bShouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10 ; i++) {
                System.out.println("sub2:" + i + " of " + j);
            }

            bShouldSub = false;
            this.notify();
        }

        public  synchronized void main(int j) {
            while (bShouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i<100; i++){
                System.out.println("main:" + i + " of " + j);
            }

            bShouldSub = true;
            this.notify();
        }
    }
}
