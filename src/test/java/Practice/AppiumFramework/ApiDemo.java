package Practice.AppiumFramework;
import java.io.IOException;
import org.testng.annotations.Test;
import PageObjects.Dependencies;
import PageObjects.HomePage;
import PageObjects.Preference;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ApiDemo extends base{
    
	@Test
	public void ApiDemoTest() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		service=startServer();
		AndroidDriver<AndroidElement> driver = capabilities("ApiDemoApp");
		
		/*
		 * xpath syntax:   //Tagname[@attribute='value']
		 */
		
		
		HomePage h=new HomePage(driver);
		//Constructor of class will be invoked when you created object of the class.
		//default constructor be called.
		//Constructor can be defined with arguments.
		
		//You can call the methods or variables of the class with class object.
		
		
		//driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		h.Preference.click();
		
		Preference p=new Preference(driver);
		Dependencies d=new Dependencies(driver);
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		p.dependencies.click();
		
		//driver.findElementById("android:id/checkbox").click();
		d.checkbox.click();
		//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		d.WifiSettings.click();
		
		//driver.findElementById("android:id/edit").sendKeys("Hello World!");
		d.editbox.sendKeys("Hello World!");
		
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		d.buttons.get(1).click();
		
		//AndroidUIAutomator syntax:  driver.findElementByAndroidUIAutomator("attribute(\"value\")")
		
		//driver.findElementByAndroidUIAutomator("text(\"Views\")").click();;
		service.stop();
		
	}

}
