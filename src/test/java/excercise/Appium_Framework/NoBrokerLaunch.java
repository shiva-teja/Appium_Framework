package excercise.Appium_Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericmethods.LandingPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.LandingPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PropertiesPageObjects;
import pageObjects.SearchPageObjects;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NoBrokerLaunch extends Base{

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(9000);
	}
	@Test(dataProvider = "InputData",dataProviderClass = TestData.class)
	public static void nobroker(String City,String locality1,String locality2,String phnumber,String password, String Addnote,String expected_successmsg) throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver;
		try {

			startserver();
			driver = capabilities("NoBroker");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			LandingPageObjects l=new LandingPageObjects(driver);
			LandingPage lp=new LandingPage(driver);
			SearchPageObjects sp=new SearchPageObjects(driver);
			PropertiesPageObjects pp=new PropertiesPageObjects(driver);
			LoginPageObjects lpp=new LoginPageObjects(driver);
			Utilities ul=new Utilities(driver);
			
			lp.allowpermissions();
			
			l.buy.click();
			
			l.searchbox.click();
			
			sp.citydropdown.click();
			
			ul.scrolltoText(City);
			lp.searchandselectautocomplete(locality1);
			lp.searchandselectautocomplete(locality2);
			
			if(sp.nearbycheckbox.getAttribute("checked").equalsIgnoreCase("false"))
			{
				lp.tapon(sp.nearbycheckbox);
			}
			
			lp.tapon(sp.twobhk);
			lp.tapon(sp.threebhk);
			
			sp.searchpropertybutton.click();
			
			pp.properties.get(0).click();
			Thread.sleep(5000);
			
			while(pp.wronginfo.size()==0)
			{
				ul.scrollDown();
			}
			
			pp.wronginfobutton.click();
			
			lpp.phonenumbertextbox.sendKeys(phnumber);
			Thread.sleep(2000);
			
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
			lpp.havepasswordradiobutton.click();
			
			lpp.passwordtextbox.sendKeys(password);
			
			driver.hideKeyboard();
			
			lpp.signupbutton.click();
			
			for(int i =0;i<lpp.reportcheckboxes.size();i++)
			{
				lpp.reportcheckboxes.get(i).click();
			}
			
			lpp.reportbutton.click();
			Thread.sleep(5000);
			
			lpp.correctdropdown.click();
			lpp.fourplusbhk.click();
			
			ul.scrollDown();
			
			lpp.addnotetextarea.sendKeys(Addnote);
			
			driver.hideKeyboard();
			
			lpp.savebutton.click();
			
			String actualsuccess_msg=lpp.successmsg.getText();
			
			Assert.assertEquals(actualsuccess_msg, expected_successmsg);
			
			service.stop();

		}catch (IOException e) {
			e.printStackTrace();
		}


	}
}
