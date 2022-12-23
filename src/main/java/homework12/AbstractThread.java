package homework12;

import java.util.concurrent.BlockingQueue;

public class AbstractThread implements Runnable{

    protected int number;
    protected final BlockingQueue<String> queue;

    public AbstractThread(BlockingQueue<String> queue, int number) {
        this.queue = queue;
        this.number = number;
    }

    @Override
    public void run() {

    }
}
