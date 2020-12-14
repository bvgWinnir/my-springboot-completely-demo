package com.bvgol.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonDemo {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("aaa", "AAA");
//        map.put("bbb", "BBB");
//        map.put("ccc", "CCC");
//
//        Object o = JSON.toJSON(map);
//        MyJson.toJsonString(o);
        JsonDemo jsonDemo = new JsonDemo();
        jsonDemo.str2json();
    }

    public void str2json() {
        String s = "{\"name\":\"test\",\"phone\":\"13344445555\",\"address\":\"中国内蒙古自治区呼和浩特市赛罕区a2\"}";
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject.get("name"));
    }
}
