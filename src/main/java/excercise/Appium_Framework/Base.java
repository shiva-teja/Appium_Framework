package excercise.Appium_Framework;

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

public class Base {
	public static AppiumDriverLocalService service;
	static AndroidDriver<AndroidElement> driver;

	public static AppiumDriverLocalService startserver()
	{
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	public static void startEmulator() throws IOException, InterruptedException
	{

		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	public static AndroidDriver<AndroidElement> capabilities(String apkname) throws IOException, InterruptedException{


		Properties prop =new Properties();
		String usrdir=System.getProperty("user.dir");
		FileInputStream fil=new FileInputStream(usrdir+"\\src\\main\\java\\excercise\\Appium_Framework\\global.properties");
		prop.load(fil);

		File f=new File("src");
		File fs=new File(f,(String) prop.get(apkname));
		DesiredCapabilities cap=new DesiredCapabilities();
		String device=(String) prop.get("device");
		startEmulator();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		//		cap.setCapability("deviceName", "Nokia 5");
		//		cap.setCapability("udid", "D1AGAD57B1003790");
//		cap.setCapability("platformName", "Android");
//		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.nobroker.app");
		//		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");

		driver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		return driver;


	}
	public static void getscreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}

}
