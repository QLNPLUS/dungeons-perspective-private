package com.cleannrooster.dungeons_iso.util;

import org.apache.logging.log4j.LogManager;

/**
 * @author ChloeCDN
 */
public class Util {

    public static void debug(String s) {
        LogManager.getLogger("Dungeons Perspective").info(s);
    }
}
