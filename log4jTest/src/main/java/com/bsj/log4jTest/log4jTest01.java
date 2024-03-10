package com.bsj.log4jTest;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

public class log4jTest01 {

    @Test
    public void test01() {
        //初始化配置
        BasicConfigurator.configure();
        //Logger logger = Logger.getLogger("com.bsj.log4jest.log4jTest01");
        Logger logger = Logger.getLogger(log4jTest01.class);

        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }

    @Test
    public void test02() {
        /**
         * 配置文件的使用
         *  1,观察源码BasicConfigurator.configure()
         *      可以得到两条信息：
         *          （1）创建了根节点的对象，Logger root = Logger.getRootLogger()
         *          (2)根节点添加了ConsoleAppender对象
         *  2，不使用BasicConfigurator.configure()
         *      使用自定义配置文件
         *          需要提供Logger、Appender、Layout这3个组件信息
         */

        /*
                %m 输出代码中指定的日志信息
                %p 输出优先级，及 DEBUG、INFO 等
                %n 换行符（Windows平台的换行符为 "\n"，Unix 平台为 "\n"）
                %r 输出自应用启动到输出该 log 信息耗费的毫秒数
                %c 输出打印语句所属的类的全名
                %t 输出产生该日志的线程全名
                %d 输出服务器当前时间，默认为 ISO8601，也可以指定格式，如：%d{yyyy年MM月dd日 HH:mm:ss}
                %l 输出日志时间发生的位置，包括类名、线程、及在代码中的行数。如：Test.main(Test.java:10)
                %F 输出日志消息产生时所在的文件名称
                %L 输出代码中的行号
                %% 输出一个 "%" 字符
                [%p]%r %c %t %d{yyyy-MM-dd HH:mm:ss:SSS} %m%n
                可以在 % 与字符之间加上修饰符来控制最小宽度、最大宽度和文本的对其方式
                [%10p]：[]中必须有10个字符，由空格来进行补齐，信息右对齐
                [%-10p]：[]中必须有10个字符，由空格来进行补齐，信息左对齐，应用较广泛
         */
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(log4jTest01.class);
        //LogManager
        //PropertyConfigurator

        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }

    @Test
    public void test03() {
        //appender
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(log4jTest01.class);

        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }

    @Test
    public void test04() {
        //RollingFileAppender
        LogLog.setInternalDebugging(true);
        Logger logger = Logger.getLogger(log4jTest01.class);

        for (int i = 0; i < 10000; i++) {
            logger.error("error 信息");
            logger.warn("warn 信息");
            logger.info("info 信息");
            logger.debug("debug 信息");
            logger.trace("trace 信息");
        }
    }

    @Test
    public void test05() {

        /**
         * CREATE TABLE tbl_log(
         *     id int primary key auto_increment,
         *     name varchar(255) default null comment '项目名称',
         *     createTime varchar(255) default null comment '创建时间',
         *     level varchar(255) default null comment '日志级别',
         *     category varchar(255) default null comment '所在类的全路径',
         *     fileName varchar(255) default null comment '文件名称',
         *     message varchar(255) default null comment '日志信息'
         * )
         */
        //logDB输出到数据库
        Logger logger = Logger.getLogger(log4jTest01.class);

        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }

    @Test
    public void test06() {
        //apache输出
        Logger logger = Logger.getLogger(Logger.class);

        logger.fatal("fatal 信息");
        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }
}
