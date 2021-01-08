package com.bvgol.examples.my.thread.completableFutureDemo;

import java.util.function.Supplier;

public class QuerySuppiler implements Supplier<String> {
    private Integer id;
    private String type;
    private QueryUtils queryUtils;

    public QuerySuppiler(Integer id, String type, QueryUtils queryUtils) {
        this.id = id;
        this.type = type;
        this.queryUtils = queryUtils;
    }

    @Override
    public String get() {
        if ("home".equals(type)) {
            return queryUtils.queryHome(id);
        } else if ("job".equals(type)) {
            return queryUtils.queryJob(id);
        } else if ("car".equals(type)) {
            return queryUtils.queryCar(id);
        }
        return null;
    }
}
