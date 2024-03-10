package com.bsj.springboot;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootLogApplicationTests {
    
    @Test
    public void test01(){
        /*
        默认使用slf4j + logback 
        默认级别是：info
         */
        Logger logger = LoggerFactory.getLogger(SpringbootLogApplicationTests.class);

        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
    @Test
    public void test02(){
        /**
         * 使用log4j2的日志实现
         * 测试log4j2的桥接
         * 使用的仍然是logback
         */
        org.apache.logging.log4j.Logger Logger = LogManager.getLogger(SpringbootLogApplicationTests.class);
        Logger.info("info信息");

    }

    @Test
    public void test03(){
        /*
        application.properties不能对日志文件拆分进行配置，所以需要另外的文件Logback.xml进行配置
         */
        Logger logger = LoggerFactory.getLogger(SpringbootLogApplicationTests.class);
        for (int i = 0; i < 100; i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");
        }
    }

    @Test
    void contextLoads() {
    }

}
