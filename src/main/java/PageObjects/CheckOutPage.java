package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckOutPage {
	
	public CheckOutPage(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	
	
	//driver.findElementsById("com.androidsample.generalstore:id/productPrice")
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
	
	//driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl")
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	
	public List<WebElement> getProductPrice()
	{   
		System.out.println("Trying to find element-productPrice.");
		return productPrice;
	}
	
	public WebElement getTotalAmount()
	{   
		System.out.println("Trying to find element-totalAmount.");
		return totalAmount;
	}

}
