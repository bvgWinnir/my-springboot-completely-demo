package com.bvgol.java7list;

import com.bvgol.list.MyJson;
import com.bvgol.utils.IdUtil;

import java.util.*;

public class DetailRecordProcessList {

    public static List<DetailRecordProcess> getSamePer() {

        return Arrays.asList(
                new DetailRecordProcess(IdUtil.UUID(), "成型（勿删）", "成型", "自动线", 1, "zzg"),
                new DetailRecordProcess(IdUtil.UUID(), "成型（勿删）", "成型", "塞棒压机", 1, "zzz"),
                new DetailRecordProcess(IdUtil.UUID(), "固化/干燥（勿删）", "固化/干燥", "5#干燥窑", 2, "zzx"),
                new DetailRecordProcess(IdUtil.UUID(), "固化/干燥（勿删）", "固化/干燥", "6#干燥窑", 2, "zxc"),
                new DetailRecordProcess(IdUtil.UUID(), "车加工（勿删）", "手工打磨", "手工打磨", 3, "zsa"),
                new DetailRecordProcess(IdUtil.UUID(), "喷涂（勿删）", "手涂", "手涂", 4, "zaq"),
                new DetailRecordProcess(IdUtil.UUID(), "烧成（勿删）", "烧成", "1#液化气窑", 5, "zsw"),
                new DetailRecordProcess(IdUtil.UUID(), "烧成（勿删）", "烧成", "4#液化气窑", 5, "zde"),
                new DetailRecordProcess(IdUtil.UUID(), "探伤（勿删）", "探伤", "2#探伤机", 6, "zxs"),
                new DetailRecordProcess(IdUtil.UUID(), "探伤（勿删）", "探伤", "1#探伤机", 6, "zxa"),
                new DetailRecordProcess(IdUtil.UUID(), "喷涂（勿删）", "刷棒头", "刷棒头", 7, "zxd"),
                new DetailRecordProcess(IdUtil.UUID(), "附加工（勿删）", "包装", "包装", 8, "zxv")
        );
    }

    public static void main(String[] args) {
        Map<String, DetailRecordProcess> map = new HashMap<>();
        List<DetailRecordProcess> l = new LinkedList<>();
        List<DetailRecordProcess> samePer = DetailRecordProcessList.getSamePer();
//        for (DetailRecordProcess d : samePer) {
//            String key = d.getProcedure() + " " + d.getWorkStep() + " " + d.getProcedureSort();
//            map.put(key, d);
//        }

        for (int i = 0; i < samePer.size(); i++) {
            String key = samePer.get(i).getProcedure() + " " + samePer.get(i).getWorkStep() + " " + samePer.get(i).getProcedureSort();
            for (int i1 = 0; i1 < samePer.size(); i1++) {
                String key1 = samePer.get(i1).getProcedure() + " " + samePer.get(i1).getWorkStep() + " " + samePer.get(i1).getProcedureSort();
                if (key.equals(key1)) {
                    samePer.get(i1).setProcedure("--");
                    samePer.get(i1).setWorkStep("--");
                    samePer.get(i1).setProcedureSort(0);
                }
            }
        }
        MyJson.toJsonString(samePer);
    }

}
