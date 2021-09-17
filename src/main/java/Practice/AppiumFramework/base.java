package Practice.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class base {
	
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	
	public AppiumDriverLocalService startServer()
	{
		
		
		boolean flag=checkIfServerIsRunnning(4723);
		if(!flag)
		{
			/*
			Map<String, String> env = new HashMap<>(System.getenv());
	        env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
	        env.put("ANDROID_HOME", "/Users/candichiu/Library/Android/sdk");
	        env.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home");
	        */
			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder()
							.usingDriverExecutable(new File("/usr/local/bin/node"))
							.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
							.withIPAddress("127.0.0.1").usingPort(4723));

			service.start();
			
		//service=AppiumDriverLocalService.buildDefaultService();
		//service.start();
		
		}
		return service;
	}
	
	public boolean checkIfServerIsRunnning(int port) {

	    boolean isServerRunning = false;
	    ServerSocket serverSocket;
	    try {
	        serverSocket = new ServerSocket(port);
	        serverSocket.close();
	    } catch (IOException e) {
	        //If control comes here, then it means that the port is in use
	        isServerRunning = true;
	    } finally {
	        serverSocket = null;
	    }
	    return isServerRunning;
	}
	
	//"/Users/candichiu/Documents/Git/Demo/AppiumFramework/src/main/java/Resources/startEmulator"
	public static void startEmulator() throws IOException, InterruptedException
	{
		
        File file=new File(System.getProperty("user.dir")+"/src/main/java/Resources/startEmulator");
		ProcessBuilder pb = new ProcessBuilder("open", file.toString());
		Process p = pb.start();
		p.waitFor();
		Thread.sleep(7000);
	
	}
	

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Practice/AppiumFramework/global.properties");
		Properties p=new Properties();
		p.load(fis);
		
		
		File appdir = new File("src");
		File app = new File(appdir, (String) p.get(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		
		String device = (String) p.get("device");
		
		//get device information from mvn command: mvn test -DdeviceName= YOUR DEVICE NAME
		//String device=System.getProperty("deviceName");
		if(device.contains("emulator"))
		{  
			
			
			startEmulator();
			Thread.sleep(30000);
			/*
			cap.setCapability("avd", device);
			Thread.sleep(10000);
			*/
		}
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
		
        driver = new AndroidDriver<>(service,cap);
        
        return driver;
		
	}
	
	public static void getScreenshot(String failed_test_case) throws IOException
	{
		File sfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sfile, new File(System.getProperty("user.dir")+"/"+failed_test_case+".png"));
		
	}

}
