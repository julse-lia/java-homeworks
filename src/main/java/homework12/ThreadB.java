package homework12;

import java.util.concurrent.BlockingQueue;

public class ThreadB extends AbstractThread{
    public ThreadB(BlockingQueue<String> queue, int number){
        super(queue, number);
    }

    @Override
    public void run() {
        if (FizzBuzz.buzz(number)){
            queue.add("buzz");
        }
    }
}
