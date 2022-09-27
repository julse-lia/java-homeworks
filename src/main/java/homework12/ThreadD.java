package homework12;

import java.util.concurrent.BlockingQueue;

public class ThreadD extends AbstractThread{
    ThreadD(BlockingQueue<String> queue, int number){
        super(queue, number);
    }

    @Override
    public void run() {
        if (!queue.isEmpty()){
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println(number);
        }
    }
}
