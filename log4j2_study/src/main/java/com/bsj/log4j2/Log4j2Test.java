package com.bsj.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2Test {
    /**
     * 单独使用log4j2
     */
    @Test
    public void test01(){
        Logger logger = LogManager.getLogger(Log4j2Test.class);
        logger.fatal("fatal 信息");
        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }
    /**
     * <Configuration status="debug">可以查看日志本身启动的详细情况
     * 
     *  根标签，所有日志相关信息，都是在根标签中进行配置
     *  <Configuration status="debug" monitorInterval="数值"></Configuration>
     *  在根标签中，可以加属性
     *  status="debug" 日志框架本身的日志输出级别
     *  monitorInterval="5" 自动加载配置文件的间隔时间，不低于5秒
     */
    
    
    /**
     * 导入依赖：
     *  1，slf4j的日志门面
     *  2,log4j2的适配器
     *  3,log4j2的日志门面
     *  4,log4j2的日志实现
     * 
     */

    @Test
    public void test02() {
        //测试文件拆分
        Logger logger = LogManager.getLogger(Log4j2Test.class);
        for(int i=0;i<1000;i++){
            logger.fatal("fatal 信息");
            logger.error("error 信息");
            logger.warn("warn 信息");
            logger.info("info 信息");
            logger.debug("debug 信息");
            logger.trace("trace 信息");
        }
    }

    @Test
    public void test03() {
        //测试异步
        Logger logger = LogManager.getLogger(Log4j2Test.class);
        for(int i=0;i<100;i++){
            logger.fatal("fatal 信息");
            logger.error("error 信息");
            logger.warn("warn 信息");
            logger.info("info 信息");
            logger.debug("debug 信息");
            logger.trace("trace 信息");
        }
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
