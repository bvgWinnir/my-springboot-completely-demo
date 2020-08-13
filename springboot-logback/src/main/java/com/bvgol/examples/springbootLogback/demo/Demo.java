package com.bvgol.examples.springbootLogback.demo;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

/**
 * @author guochen
 * @Title:
 * @Package
 * @Description:
 * @date 2020/6/2721:22
 */
public class Demo {
    //这里的包可能没有引对
    private Logger xiaojia = (Logger) LoggerFactory.getLogger("xiaojia");

}

@Slf4j(topic = "xiaojia")
class XiaoJiaTest {

}
