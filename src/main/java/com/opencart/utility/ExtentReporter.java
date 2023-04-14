package com.opencart.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ExtentReporter {

	static ExtentReports extentReports;

	public static ExtentReports getExtentReport() {
		String extentReportsPath = System.getProperty("user.dir") + "\\reports\\extentReports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportsPath);
		reporter.config().setReportName("ExtentReports");
		reporter.config().setDocumentTitle("TestResults");

		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("OS", "Windows 10");
		extentReports.setSystemInfo("Tested By", "Nikhil k");

		return extentReports;
	}
	

}
