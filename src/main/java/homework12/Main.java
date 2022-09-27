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
            try {
                ExecutorService pool = Executors.newFixedThreadPool(3);
                pool.execute(new ThreadA(q, i));
                pool.execute(new ThreadB(q, i));
                pool.execute(new ThreadC(q, i));
                pool.shutdown();
            } catch (Exception err) {
                err.printStackTrace();
                return;
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
