package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyOnlinePlans {

	public WebDriver driver;
// first part
	@FindBy(id = "nv_leadform_content-iframe_2400")
	private WebElement iframe;
	@FindBy(xpath = "//span[@id='nv_js-leadform-close-button_2400']")
	private WebElement closebutton;
	@FindBy(xpath = "//*[@data-action='online plans']")
	private WebElement onlinePlansHover;
	@FindBy(xpath = "/html/body/header/div[2]/nav/ul/li[1]/div/ul/li[2]/div[2]/ul/li[1]/a/span")
	private WebElement TermIP;
// second part 
//	Constructor
	public BuyOnlinePlans(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
// third part
 	public void manage_iframe() {
		driver.switchTo().frame(iframe);
		closebutton.click();
	}

	public void onlinPlans() {
		Actions act = new Actions(driver);
		act.moveToElement(onlinePlansHover).perform();
		TermIP.click();
	}
	public String verifyUrl() 
	{
	String url=driver.getCurrentUrl();
	return url;
	}
}
