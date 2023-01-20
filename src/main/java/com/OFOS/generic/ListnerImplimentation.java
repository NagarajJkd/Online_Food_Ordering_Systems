package com.OFOS.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplimentation extends BaseClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// Execution is starts from here
		String text = result.getMethod().getMethodName();
		test=report.createTest(text);
		Reporter.log(text+"--->Test Execution is strats from here");
	}

	public void onTestSuccess(ITestResult result) {
		String text = result.getMethod().getMethodName();
		test.log(Status.PASS, text+"----->Passed");
		Reporter.log(text+"----->TestScript Execution is Successfull");
		
	}

	public void onTestFailure(ITestResult result) {
		String text = result.getMethod().getMethodName();
		String currentsysformate = ju.getSystemDateAndTimeInFormate();
		EventFiringWebDriver sdriver=new EventFiringWebDriver(driver);
		File src = sdriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./FTCScreenshot/"+text+currentsysformate+".png");
		String FP = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(FP);
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("---TestScript Execution is failed--");
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"------>Skipped");
		Reporter.log("--TestScript Execution is skipped--");
	}

	public void onStart(ITestContext context) {

		// Configuration Report ExtentsSparkReport
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("OFOS Project Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("OFOS Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Base_URL", "https://mvnrepository.com/artifact/com.aventstack/extentreports/5.0.9");
		report.setSystemInfo("Reporter Name", "Nagaraj");

	}

	public void onFinish(ITestContext context) {
		// consolidate the report
		report.flush();
	}

	
}
