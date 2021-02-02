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
	@Test
	public static void nobroker() throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver;
		try {

			startserver();
			driver = capabilities("NoBroker");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			LandingPageObjects l=new LandingPageObjects(driver);
			LandingPage lp=new LandingPage(driver);
			SearchPageObjects sp=new SearchPageObjects(driver);
			lp.allowpermissions();
//			l.permissioncontinue.click();
//			l.allowlocation.click();	
//			l.allowcontacts.click();
//			l.allowcalls.click();
			l.buy.click();
			
			l.searchbox.click();
			
			sp.citydropdown.click();
			
			sp.selectcity.click();
			
			
			lp.searchandselectautocomplete("Marathahalli");
			lp.searchandselectautocomplete("HSR Layout");
			
			TouchAction t = new TouchAction(driver);
			if(sp.nearbycheckbox.getAttribute("checked").equalsIgnoreCase("false"))
			{
//				t.tap(tapOptions().withElement(element(sp.nearbycheckbox))).perform();
				lp.tapon(sp.nearbycheckbox);
			}
//			t.tap(tapOptions().withElement(element(sp.twobhk))).perform();
//			t.tap(tapOptions().withElement(element(sp.threebhk))).perform();
			lp.tapon(sp.twobhk);
			lp.tapon(sp.threebhk);
			
			sp.searchpropertybutton.click();
			
			PropertiesPageObjects pp=new PropertiesPageObjects(driver);
			Utilities ul=new Utilities(driver);
//			ul.scrollDown();
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println(pp.properties.size());
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			
			pp.properties.get(0).click();
			Thread.sleep(5000);
			
			
			while(pp.wronginfo.size()==0)
			{
				ul.scrollDown();
			}
			
//			for(int i=0;i<6;i++)
//	        {
//	            	ul.scrollDown();
//	            	System.out.println(pp.wronginfo.size());
//	        }
			pp.wronginfobutton.click();
			
			LoginPageObjects lpp=new LoginPageObjects(driver);
			lpp.phonenumbertextbox.sendKeys("1237567899");
//			driver.navigate().back();
			Thread.sleep(2000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			lpp.havepasswordradiobutton.click();
			lpp.passwordtextbox.sendKeys("nobroker123");
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
			
			lpp.addnotetextarea.sendKeys("Testing");
			
			driver.hideKeyboard();
			
			lpp.savebutton.click();
			
			String expected_successmsg="Thank you for the feedback";
			String actualsuccess_msg=lpp.successmsg.getText();
			
			Assert.assertEquals(actualsuccess_msg, expected_successmsg);
			
			
			
			
			
			
//			ul.scrollDown();
			
			
			
			
//			ul.scrollAndClick("Wrong Info");
			
//			lp.flingVerticalToBottom_Android();
			
//			while (driver.findElements(By.id("com.nobroker.app:id/tv_report_wrong_info")).size()==0)
//			{
//
//				Dimension size = driver.manage().window().getSize();
//				int starty = (int) (size.height * 0.80);
//				int endy = (int) (size.height * 0.20);
//				int startx = size.width / 2;
//				System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
//
//				t.tap(point())
//				driver.swipe(startx, starty, startx, endy, 3000);
//				Thread.sleep(2000);
//				driver.swipe(startx, endy, startx, starty, 3000);
//				Thread.sleep(2000);
//				}
			
			
//			ul.scrolltoText("Wrong Info");
//			ul.scrolltoTextadvance("com.nobroker.app:id/tv_report_wrong_info", "Wrong Info");
			
			
			
//			sp.localitytextbox.sendKeys("Marathahalli");
//			
//			driver.hideKeyboard();
//			
//			int x =  sp.localitytextbox.getLocation().getX();
//			int y = sp.localitytextbox.getLocation().getY();
//
//			System.out.println("X value: “+x+” Y value: "+y);
//			Thread.sleep(2000);
//
//			TouchAction action = new TouchAction(driver).tap(point(x+60, y+260)).release();
////			action.tap(point(x+60, y+260)).release().perform();
//			action.perform();
//			action.tap(tapOptions().withPosition(x+60, y+260))
			
			
			
			
			
			service.stop();

		}catch (IOException e) {
			e.printStackTrace();
		}


	}
}
