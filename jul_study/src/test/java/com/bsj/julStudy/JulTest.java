package com.bsj.julStudy;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.*;

public class JulTest {


    @Test
    public void test() {
        System.out.println(1);
    }

    @Test
    public void test2() {
        Logger logger = Logger.getLogger("com.bsj.julStudy.JulTest");

        /**
         * 日志的输入有两种方式
         * 第一种方式：
         *  直接调用日志级别相关的方法，方法传递中日志输出信息
         *  假设现在我们要输入info级别的日志信息
         *  */
        //logger.info("输出日志信息");
        /**
         * 第二种方式：
         * 调用通用的log方法，然后在里面通过level类型来定义日志的级别参数，以及搭配日志输出信息
         * 的参数
         */
        //logger.log(Level.INFO,"输入日志信息");

        String name = "张三";
        int age = 18;
        /**
         * 1，可读性不强
         * 2，程序效率低
         * */
        //logger.log(Level.INFO,"学生信息：姓名="+name+",年龄="+age);


        //用另种方式 ，类似于prepareStatement
        logger.log(Level.INFO, "学生信息：姓名＝{0},年龄={1}", new Object[]{name, age});
    }

    @Test
    public void test3() {
        /**
         * 日志 级别：
         *  SERVER:错误 最高级别
         *  WARNING
         *  INFO:默认
         *  CONFIG
         *  FINE
         *  FINER
         *  FINEST:详细信息
         *
         *
         *  两个特殊级别：
         *  OFF:关闭日志
         *  ALL：启用所有
         */
        Logger logger = Logger.getLogger("com.bsj.julStudy.JulTest");

        /**
         * 单独使用没有用
         */
        logger.setLevel(Level.FINER);

        logger.severe("server 信息");
        logger.warning("warning 信息");
        logger.info("info 信息");
        logger.config("config 信息");
        logger.fine("fine 信息");
        logger.finer("finer 信息");
        logger.finest("finest 信息");
    }

    @Test
    public void test4(){
        Logger logger = Logger.getLogger("com.bsj.julStudy.JulTest");

        //将默认的shutdown default logger
      logger.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        consoleHandler.setFormatter(simpleFormatter);

        logger.addHandler(consoleHandler);

        //logger.setLevel(Level.CONFIG);
        //consoleHandler.setLevel(Level.CONFIG);
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);


        /**
         * test
         */
        logger.severe("server 信息");
        logger.warning("warning 信息");
        logger.info("info 信息");
        logger.config("config 信息");
        logger.fine("fine 信息");
        logger.finer("finer 信息");
        logger.finest("finest 信息");
    }

    @Test
    public void test5() throws IOException {
        /**
         * print to disk
         */
        Logger logger = Logger.getLogger("com.bsj.julStudy.JulTest");

        //将默认的shutdown default logger
        logger.setUseParentHandlers(false);

        //disk file
        FileHandler fileHandler = new FileHandler("/home/brh/myCode/log/myLog.log",true);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        //console print
        ConsoleHandler consoleHandler = new ConsoleHandler();

        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);

        logger.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        /**
         * test
         */
        logger.severe("server 信息");
        logger.warning("warning 信息");
        logger.info("info 信息");
        logger.config("config 信息");
        logger.fine("fine 信息");
        logger.finer("finer 信息");
        logger.finest("finest 信息");
    }

    @Test
    public void test6() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("logging.properties");

        LogManager logManager = LogManager.getLogManager();

        logManager.readConfiguration(fileInputStream);

        Logger logger = Logger.getLogger("com.bsj.julStudy.JulTest");

        /**
         * test
         */
        logger.severe("server 信息");
        logger.warning("warning 信息");
        logger.info("info 信息");
        logger.config("config 信息");
        logger.fine("fine 信息");
        logger.finer("finer 信息");
        logger.finest("finest 信息");

    }
    /**
     * JUL日志使用总结：
     *  1，LogManager.getLogManager() 这是用static修饰的，内存中只有一份，不会复制，所以是单例的
     *  这一步是进行logManager初始化
     *  2，获取logger
     *  3,设置logger.level
     *  4,handler
     *  5,filter
     *  6,formatter
     */
}
