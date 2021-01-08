package com.bvgol.examples.my.thread.completableFutureDemo;

public class UserInfo {
    private Integer id;
    private String name;
    private Integer jobId;
    private String jobDes;
    private Integer carId;
    private String carDes;
    private Integer homeId;
    private String homeDes;

    public Integer getId() {
        return id;
    }

    public UserInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getJobId() {
        return jobId;
    }

    public UserInfo setJobId(Integer jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getJobDes() {
        return jobDes;
    }

    public UserInfo setJobDes(String jobDes) {
        this.jobDes = jobDes;
        return this;
    }

    public Integer getCarId() {
        return carId;
    }

    public UserInfo setCarId(Integer carId) {
        this.carId = carId;
        return this;
    }

    public String getCarDes() {
        return carDes;
    }

    public UserInfo setCarDes(String carDes) {
        this.carDes = carDes;
        return this;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public UserInfo setHomeId(Integer homeId) {
        this.homeId = homeId;
        return this;
    }

    public String getHomeDes() {
        return homeDes;
    }

    public UserInfo setHomeDes(String homeDes) {
        this.homeDes = homeDes;
        return this;
    }
}
