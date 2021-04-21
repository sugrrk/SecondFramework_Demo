package com.wbl1.util1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoggerListener1 extends TestListenerAdapter {
    Logger logger = (Logger) LogManager.getLogger(LoggerListener1.class);

    @Override
    public void onTestStart(ITestResult tr){
        logger.info("Test started.");

    }
    @Override
    public void onTestSuccess(ITestResult tr){
        logger.info("Test" + tr.getName() + "Passed");
        logger.info("Priority of this method is " + tr.getMethod().getPriority());
    }

    @Override
    public void onTestFailure(ITestResult tr){
        logger.error("Test" + tr.getName() + "Failed");
        logger.error("Priority of this method is " + tr.getMethod().getPriority());

    }
    @Override
    public void onTestSkipped(ITestResult tr){
        logger.warn("Test" + tr.getName() + "Skipped");


    }
}


