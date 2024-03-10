import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class JCLTest01 {
    private Log logger = LogFactory.getLog(JCLTest01.class);

    @Test
    public void test01(){
        /**
         * 如果没有导入第三方的日志框架，例如log4j
         * 则使用默认的JUL
         */
        //Log logger = LogFactory.getLog(JCLTest01.class);

        logger.fatal("fatal 信息");
        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }

    @Test
    public void test02(){
        /**
         * 导入了log4后，则优先使用log4j
         * 日志门面技术，不再依赖具体的实现类，减少代码的耦合性
         */
        //Log logger = LogFactory.getLog(JCLTest01.class);

        logger.fatal("fatal 信息");
        logger.error("error 信息");
        logger.warn("warn 信息");
        logger.info("info 信息");
        logger.debug("debug 信息");
        logger.trace("trace 信息");
    }
}
