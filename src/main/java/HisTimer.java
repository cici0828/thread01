import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class HisTimer {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
//        new Timer().schedule(new TimerTask(){
//
//            public void run() {
//                System.out.println("bombing");
//            }
//        }, 0, 3000);

        class MyTimerTask extends TimerTask {
            public void run() {
                count = (count + 1) % 2;
                System.out.println("bombing");
                new Timer().schedule(new MyTimerTask(), 2000 + 2000*count);
            }
        }

        new Timer().schedule(new MyTimerTask(), 2000);

        while (true) {
            System.out.println(new Date().getSeconds());
            Thread.sleep(1000);
        }
    }
}
