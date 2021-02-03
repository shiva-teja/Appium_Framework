package genericmethods;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import excercise.Appium_Framework.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObjects.LandingPageObjects;
import pageObjects.SearchPageObjects;

public class LandingPage extends Base{
	AndroidDriver<AndroidElement> driver;
	public LandingPage(AndroidDriver<AndroidElement> driver_base)
	{
		this.driver=driver_base;
	}
	public void allowpermissions()
	{
		LandingPageObjects l=new LandingPageObjects(driver);
		l.permissioncontinue.click();
		l.allowlocation.click();	
		l.allowcontacts.click();
		l.allowcalls.click();
	}
	public void searchandselectautocomplete(String text) throws InterruptedException
	{
		SearchPageObjects sp=new SearchPageObjects(driver);
		sp.localitytextbox.sendKeys(text);
		TouchAction t = new TouchAction(driver);
		int x =  sp.localitytextbox.getLocation().getX();
		int y = sp.localitytextbox.getLocation().getY();
		System.out.println("X value: “+x+” Y value: "+y);
		Thread.sleep(2000);
		t.tap(point(x+60, y+260)).release();
		t.perform();
	}
	public void tapon(WebElement ele)
	{
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(ele))).perform();
	}
}
