package com.bvgol.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bvgol.list.MyJson;

import java.util.HashMap;
import java.util.Map;

public class JsonDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "AAA");
        map.put("bbb", "BBB");
        map.put("ccc", "CCC");

        Object o = JSON.toJSON(map);
        MyJson.toJsonString(o);
    }
}
