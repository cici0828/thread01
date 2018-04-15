public class HisSyn {

    public static void main(String[] args) {
        new HisSyn().init();
    }

    public void init(){
        final Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        outputer.output("fengwei");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        outputer.output("sunchanjing");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    class Outputer{
        //方法上的synchronized用的当前方法对象
        public synchronized void  output(String name){
            int len = name.length();
            //synchronized(name) { 这样是不行的
            //synchronized(this){ 这样是可以的
            {
                for (int i = 0; i < len; i++)
                    System.out.print(name.charAt(i));
                System.out.println();
            }
        }
    }
}
