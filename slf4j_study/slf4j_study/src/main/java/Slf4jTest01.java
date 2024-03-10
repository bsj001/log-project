import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Slf4jTest01 {

    /**
     * 日志出现时间：log4j -> jul -> logback -> log4j2
     *  中间出现日志门面：jcl -> slf4j
     */

    @Test
    public void test01(){
        //slf4j的日志级别：trace/debug/info/warn/error
        Logger logger = LoggerFactory.getLogger(Slf4jTest01.class);

        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");

    }

    @Test
    public void test02(){
        //slf4j的日志级别：trace/debug/info/warn/error
        Logger logger = LoggerFactory.getLogger(Slf4jTest01.class);

        String name = "zs";
        int age = 18;

        logger.info("student information:name={},age={}",name,age);
    }

    @Test
    public void test03(){
        /**
         * 如果有多个日志依赖实现，则按先导入的日志依赖输出
         */
        Logger logger = LoggerFactory.getLogger(Slf4jTest01.class);
        try {
            Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            logger.info("发生了错误，错误信息如下：",e);
        }
    }

    @Test
    public void test04(){
        /**
         * 测试nop
         */
        Logger logger = LoggerFactory.getLogger(Slf4jTest01.class);
        try {
            Class.forName("aaa");
        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            logger.info("发生了错误，错误信息如下：",e);
        }
    }

    @Test
    public void test05(){
        //slf4j出现的比log4j和jul晚，所以要实现Log4j和jul需要导入适配依赖
        //测试log4j和jul适配slf4j
        Logger logger = LoggerFactory.getLogger(Slf4jTest01.class);

        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }
}
