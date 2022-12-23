package homework12;

import java.util.concurrent.BlockingQueue;

public class ThreadC extends AbstractThread{
    public ThreadC(BlockingQueue<String> queue, int number){
        super(queue, number);
    }

    @Override
    public void run() {
        if (FizzBuzz.fizzbuzz(number)){
            queue.add("fizzbuzz");
        }
    }
}
