package com.bvgol.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class FastJsonTest {

    public static void main(String[] args) {
        String s = JSON.toJSONString(new Book("nameValue", "bvgol", "test", LocalDateTime.now()));
        JSONObject jsonObject = JSONObject.parseObject(s);
        String name = jsonObject.getString("name2");
        System.out.println(name);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Book {
    private String name;
    private String author;
    private String title;
    private LocalDateTime localDateTime;
}