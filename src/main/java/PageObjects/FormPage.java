package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	
	//driver.findElementsById("com.androidsample.generalstore:id/productPrice")
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countrySelect;
	
	//driver.findElementById("com.androidsample.generalstore:id/nameField")
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement NameField;
	
	//driver.findElementByXPath("//*[@text='Female']")
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement FemaleOption;
	
	
	public WebElement getCountrySelect()
	{
		System.out.println("Trying to find element-countrySelect.");
		return countrySelect;
	}
	
	public WebElement getFemaleOption()
	{
		System.out.println("Trying to find element-FemaleOption.");
		return FemaleOption;
	}

}
