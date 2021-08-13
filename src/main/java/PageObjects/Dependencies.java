package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dependencies {

	public Dependencies(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> buttons;
	
	@AndroidFindBy(id="android:id/checkbox")
	public WebElement checkbox;
	
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]")
	public WebElement WifiSettings;
	
	@AndroidFindBy(id="android:id/edit")
	public WebElement editbox;
	
	
	
}
