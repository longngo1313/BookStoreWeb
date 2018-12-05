package com.nguyenvulong2002.bookclient.utils;

import java.util.logging.Logger;

public class LoggerUtil {
	
	public static boolean sIsStateDebug = true;
	
    public enum eStatusLog {
        ERROR, DEBUG, ASSET, VERBOSE, WARN, INFO
    }

    public static void setLog(Object className, eStatusLog log, String tag, Object value) {
    	Logger logger = Logger.getLogger(className.getClass().getName());
    	if(value == null) {
    		value = "null";
    	}
        switch (log) {
            case ERROR:
            	logger.severe(tag + " : " + value.toString());
                break;
            case DEBUG:
                if (sIsStateDebug) {
                	logger.info(tag + " : " + value.toString());
                }
                break;
            case VERBOSE:
                if (sIsStateDebug) {
                	logger.info(tag + " : " + value.toString());
                }

                break;
            case WARN:
            	logger.warning(tag +  " : " + value.toString());
                break;
            case INFO:
                if (sIsStateDebug) {
                	logger.info(tag + " : " + value.toString());
                }
                break;
        }
    }
}
