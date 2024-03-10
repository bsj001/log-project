package com.bsj.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest01 {

    @Test
    public void test01(){
        /**
         * 配置logback.xml默认为追加
         */
        Logger logger = LoggerFactory.getLogger(LogbackTest01.class);
        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }
    @Test
    public void test02(){
        /**
         * 拆分
         */
        Logger logger = LoggerFactory.getLogger(LogbackTest01.class);
        for (int i = 0; i < 1000; i++) {
            logger.error("error 信息");
            logger.warn("warn 信息");
            logger.info("info 信息");
            logger.debug("debug 信息");
            logger.trace("trace 信息");
        }
    }
    @Test
    public void test03(){
        /**
         * 异步日志记录
         */
        Logger logger = LoggerFactory.getLogger(LogbackTest01.class);
        for (int i = 0; i < 100; i++) {
            logger.error("error 信息");
            logger.warn("warn 信息");
            logger.info("info 信息");
            logger.debug("debug 信息");
            logger.trace("trace 信息");
        }
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
    }
}
