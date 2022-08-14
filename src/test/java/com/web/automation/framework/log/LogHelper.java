package com.web.automation.framework.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper
{
    //Initialize Log4j instance
    Logger Log =  LogManager.getLogger(getClass());

    //Info Level Logs
    public void info (String message) {
        Log.info(message);
    }

    //Warn Level Logs
    public void warn (String message) {
        Log.warn(message);
    }

    //Error Level Logs
    public void error (String message) {
        Log.error(message);
    }

    //Fatal Level Logs
    public void fatal (String message) {
        Log.fatal(message);
    }

    //Debug Level Logs
    public void debug (String message) {
        Log.debug(message);
    }
}
