package Practice.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	
	public static AppiumDriverLocalService service;
	
	public void startServer()
	{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		
	}

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		// TODO Auto-generated method stub
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Practice/AppiumFramework/global.properties");
		Properties p=new Properties();
		p.load(fis);
		
		
		File appdir = new File("src");
		File app = new File(appdir, (String) p.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
		String device = (String) p.get("device");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10");
		
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        
        return driver;
		
	}

}
