package util;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {
	public static ExtentReports report;

	public static ExtentReports getReportInstance() {
		if (report == null) {

			Date date = new Date();
			String reportName = date.toString().replace(":", "_").replace(" ", "_") +".html";
			
			/*
			 * the reports generated while testing the program multiple times.
			 */

			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\test-output\\" + reportName);

			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			// Stating some of the system info in the report in which the project has run
			report.setSystemInfo("OS", "Windows 07");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "10.8.1");
			report.setSystemInfo("Browser", "chrome");

			// Stating some of the project info in the report
			htmlReporter.config().setDocumentTitle("PolicyBazzar Automation Results");
			htmlReporter.config().setReportName("All Headlines of policyBazzar Automation");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		}

		return report;

	}

}



