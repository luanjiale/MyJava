package threadgroup;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author LuanJiale
 * @date 2020/5/25 0:51
 */
public class Searcher implements Runnable {

    private Result result;

    public Searcher(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        //name为当前线程的名字
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: 启动\n" , name);
        try {
            doTask();
        } catch (InterruptedException e) {
            System.out.printf("线程 %s 被中断\n" ,name);
        }
        System.out.printf("线程 %s ：完成\n" , name);
    }

    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int)random.nextDouble()*100;
        System.out.printf("Thread %s: %d\n",Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(5);
    }
}
