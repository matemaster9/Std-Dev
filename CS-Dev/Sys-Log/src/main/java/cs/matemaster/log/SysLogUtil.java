package cs.matemaster.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 21:18
 */
public class SysLogUtil {
    private static final Logger info = LoggerFactory.getLogger("StdOut");
    private static final Logger err = LoggerFactory.getLogger("StdErr");
    private static final Logger debug = LoggerFactory.getLogger("Debug");

    public static void info(String msg) {
        info.info(msg);
    }

    public static void err(String error) {
        err.error(error);
    }

    public static void debug(String msg) {
        debug.debug(msg);
    }
}
