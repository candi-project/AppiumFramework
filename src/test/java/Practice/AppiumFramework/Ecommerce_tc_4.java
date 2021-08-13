package Practice.AppiumFramework;


import org.testng.annotations.Test;

import PageObjects.CheckOutPage;
import PageObjects.FormPage;
import PageObjects.Utilities;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Ecommerce_tc_4 extends base{

	@Test  
	public void ecommerceTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		startServer();
		
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		FormPage FormPage=new FormPage(driver);
		
		//FormPage.countrySelect.click();
		FormPage.getCountrySelect().click();
		
	//	driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		Utilities u=new Utilities(driver);
		u.ScrollTo("Belgium");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));").click();
 //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		
		FormPage.NameField.sendKeys("Candi");
		//driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Candi");
		driver.hideKeyboard();
		FormPage.getFemaleOption().click();
		//driver.findElementByXPath("//*[@text='Female']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
        //System.out.println(driver.findElementsById("com.androidsample.generalstore:id/productName").size());
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
		
		int productNumber = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for(int i=0;i<productNumber;i++)
		{
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if (text.equalsIgnoreCase("Converse All Star"))
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		  	
		}
		
		Thread.sleep(2000);
		driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Nike SFB Jungle\").instance(0))");
		int productNumber2 = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		
		for(int i=0;i<productNumber2;i++)
		{
			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if (text.equalsIgnoreCase("PG 3"))
			{
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		  	
		}
		
		
		
		
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		
	    Thread.sleep(4000);
		
	    CheckOutPage CheckOutPage=new CheckOutPage(driver);
	    
	    int count = CheckOutPage.getProductPrice().size();
	    
	    double sum = 0;
	    
	    for(int j=0;j<count;j++)
	    {
	    	String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(j).getText(); 
	    	double amountValue = getAmount(amount);
	    	sum =sum+amountValue;
	    }
	    
//		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText(); 
//		//$55.0
//		String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
//		//$110.0
		
//		//remove dollar sign
//		amount1 = amount1.substring(1);
//		amount2 = amount2.substring(1);
//		
//		//Convert type to Double 
//		double amount1Value = Double.parseDouble(amount1);
//		double amount2Value = Double.parseDouble(amount2);
		
//		double amount1Value = getAmount(amount1);
//		double amount2Value = getAmount(amount2);
//		
//		double sumofValue = amount1Value + amount2Value ;
		System.out.println("Sum of Value: "+ sum);
		
		
		String totalAmount = CheckOutPage.getTotalAmount().getText();
		//$ 165.0
		
		double totalValue = getAmount(totalAmount);
		System.out.println("total Value: "+ totalValue);
		
		Assert.assertEquals(totalValue, sum);
		
		
		//Mobile Gesture
		TouchAction t = new TouchAction(driver);
		
		WebElement checkbox = driver.findElementByXPath("//*[@text='Send me e-mails on discounts related to selected products in future']");
		WebElement link = driver.findElementById("com.androidsample.generalstore:id/termsButton");
		//tap
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		//long-press
		t.longPress(longPressOptions().withElement(element(link)).withDuration(ofSeconds(2))).release().perform();
		driver.findElementById("android:id/button1").click();
		driver.findElementByClassName("android.widget.Button").click();
		
		
	}
	
	public static double getAmount(String value) {
		
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		return amountValue;
				
	}

}
