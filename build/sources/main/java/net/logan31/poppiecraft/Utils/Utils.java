package net.logan31.poppiecraft.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by johanjulien on 29/07/2017.
 */
public class Utils {
    private static Logger logger;
    public static Logger getLogger() {
        if(logger == null)
            logger = LogManager.getFormatterLogger(References.MODID);
        return logger;
    }




}
