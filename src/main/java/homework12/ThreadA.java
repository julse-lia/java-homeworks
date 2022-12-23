package homework12;

import java.util.concurrent.BlockingQueue;

public class ThreadA extends AbstractThread {

    public ThreadA(BlockingQueue<String> queue, int number){
        super(queue, number);
    }

    @Override
    public void run() {
        if (FizzBuzz.fizz(number)){
            queue.add("fizz");
        }
    }
}
