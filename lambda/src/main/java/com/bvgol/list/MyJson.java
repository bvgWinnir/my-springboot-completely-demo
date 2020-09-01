package com.bvgol.list;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2910:37
 */
public class MyJson {
    public static void toJsonString(Object o) {
        System.out.println(JSONObject.toJSONString(o,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
    }
}
