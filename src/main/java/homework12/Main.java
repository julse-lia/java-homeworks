package homework12;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> q = new LinkedBlockingQueue<>();

        for (int i = 1; i < 16; i++) {
            Thread d = new Thread(new ThreadD(q, i));

            try{
                Thread a = new Thread(new ThreadA(q, i));
                Thread b = new Thread(new ThreadB(q, i));
                Thread c = new Thread(new ThreadC(q, i));

                a.start();
                b.start();
                c.start();

                a.join();
                b.join();
                c.join();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            d.start();
            try {
                d.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Done.");
    }
}
