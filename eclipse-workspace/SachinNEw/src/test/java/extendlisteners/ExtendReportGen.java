package extendlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportGen {
	 static ExtentReports extent;
	public static ExtentReports extentReportGenerator() {
		String path = System.getProperty("user.dir") + "\\reports\\spTestreport.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("MyReport");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		extent.setSystemInfo("ProjectName", "KotakGeneralInsuraNce");
		extent.setSystemInfo("Enviroment", "StageEnviroment");
		extent.setSystemInfo("Executed By", "SachinPawar");

		return extent;

	}
}
