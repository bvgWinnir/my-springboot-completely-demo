package com.bvgol.lambda.forkjoin;/**
 * @Classname ForkJoinCal
 * @Description TODO
 * @Date 2020/11/3 16:54
 * @Created by GUOCHEN
 */

import java.util.concurrent.RecursiveTask;

/**
 * @program: my-springboot-completely
 * @description:
 * @author: GUOCHEN
 * @create: 2020/11/03 16:54
 */
public class ForkJoinCal extends RecursiveTask<Long> {
    private static final long serialVersionUID = 123123132123L;
    private long start;
    private long end;
    private static final long THRESHOLD = 10000;

    public ForkJoinCal(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinCal left = new ForkJoinCal(start, middle);
            ForkJoinCal right = new ForkJoinCal(middle + 1, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }

}
