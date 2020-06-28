package com.bvgol.springbootjapiDocs.demo;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

public class ProductDoc {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        config.setProjectPath("D:\\springboot-JAPIDocs\\src\\main\\java\\com"); // 项目根目录
        config.setProjectName("push_robot_server"); // 项目名称
        config.setApiVersion("V1.0");       // 声明该API的版本
        config.setDocsPath("D:\\springboot-JAPIDocs\\src\\main\\java\\com\\doc"); // 生成API 文档所在目录
        config.setAutoGenerate(Boolean.TRUE);  // 配置自动生成
        config.setCodeTplPath("classpath:doc/api-controller.html.ftl");
        Docs.buildHtmlDocs(config); // 执行生成文档
    }
}