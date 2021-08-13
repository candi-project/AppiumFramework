package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


//All the objects belonging to one page will be defined in java class.
public class HomePage {
	
	//Concatenate driver
	public HomePage(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	
	//@iOSXCUITFindBy
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preference;

}
