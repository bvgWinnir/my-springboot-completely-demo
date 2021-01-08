package com.bvgol.examples.my.thread.completableFutureDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author idea
 * @data 2020/2/22
 */
public class QueryUtils {
    public String queryCar(Integer carId) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "car_desc";
    }

    public String queryJob(Integer jobId) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "job_desc";
    }

    public String queryHome(Integer homeId) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "home_desc";
    }
}
