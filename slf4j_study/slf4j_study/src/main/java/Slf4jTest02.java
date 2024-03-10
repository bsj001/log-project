import org.apache.log4j.Logger;
import org.junit.Test;



public class Slf4jTest02 {

    @Test
    public void test05(){
        //log4j桥接
        //要求在不改变源码的情况下，使用slf4j+logback替换 log4j
        Logger logger = Logger.getLogger(Slf4jTest02.class);

        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }
}
