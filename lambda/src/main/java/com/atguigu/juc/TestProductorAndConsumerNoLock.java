package com.atguigu.juc;

/**
 * @program: my-springboot-completely
 * @description: 生产消费模式--未加锁
 * @author: GUOCHEN
 * @create: 2021/01/06 22:23
 */
public class TestProductorAndConsumerNoLock {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor pro = new Productor(clerk);
        Consumer con = new Consumer(clerk);

        new Thread(pro, "生产者 A").start();
        new Thread(con, "消费者 B").start();
    }
}

class Clerk {
    private int product = 0;

    // 进货
    public void get() {
        if (product >= 1) {
            System.out.println("产品已满！");
        } else {
            System.out.println(Thread.currentThread().getName() + " : "
                    + ++product);
        }
    }

    // 卖货
    public void sale() {
        if (product <= 0) {
            System.out.println("缺货！");
        } else {
            System.out.println(Thread.currentThread().getName() + " : "
                    + --product);

        }
    }
}

// 生产者
class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.get();
        }
    }
}

// 消费者
class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }

}
