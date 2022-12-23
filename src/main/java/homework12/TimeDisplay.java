package homework12;

public class TimeDisplay {
    public static void main(String[] args) {
        new Thread(() -> {
            long start = System.currentTimeMillis();
            while (true)
            {
                long time = System.currentTimeMillis() - start;
                long seconds = time / 1000;
                System.out.println("Time Passed: " + seconds + " seconds");
                try {
                    Thread.sleep(1000);
                } catch(Exception e) {

                }
            }
        }).start();

        new Thread(() -> {
            while (true)
            {
                try {
                    Thread.sleep(5000);
                } catch(Exception e) {

                }
                System.out.println("5 seconds passed");
            }
        }).start();
    }
}
