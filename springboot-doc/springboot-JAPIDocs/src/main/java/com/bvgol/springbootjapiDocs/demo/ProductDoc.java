package com.bvgol.springbootjapiDocs.demo;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

public class ProductDoc {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("D:\\idea_projects\\my-springboot-completely-demo\\springboot-JAPIDocs");
        // 项目名称
        config.setProjectName("push_robot_server");
        // 声明该API的版本
        config.setApiVersion("V1.0");
        // 生成API 文档所在目录
        config.setDocsPath("D:\\springboot-JAPIDocs\\doc");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
//        config.setCodeTplPath("classpath:doc/api-controller.html.ftl");
        // 执行生成文档
        Docs.buildHtmlDocs(config);
    }
}
