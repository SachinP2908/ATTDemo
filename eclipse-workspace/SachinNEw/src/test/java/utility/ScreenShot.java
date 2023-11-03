package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static String captureScreenshotWithReturnPath(WebDriver driver, String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
//		File destination = new File("C://Users//sachin//Desktop//screnshot//"+name+".png");
		String path = System.getProperty("user.dir") + "\\screenshots\\" + name + ".png";
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;
	}

	public static void captureScreenshot(WebDriver driver, String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C://Users//sachin//Desktop//screnshot//" + name + ".png");
		FileHandler.copy(source, destination);
	}
}
