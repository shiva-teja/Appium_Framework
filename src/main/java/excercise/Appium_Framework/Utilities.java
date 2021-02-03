package excercise.Appium_Framework;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Utilities {

	AndroidDriver<AndroidElement> driver;

	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}
	public void scrolltoText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));").click();
	}
	public void scrolltoTextadvance(String list,String text)
	{
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\""+list+"\")).scrollIntoView(new UiSelector().textMatches(\""+text+"\").instance(0))"));
	}
	public void scrollAndClick(String visibleText) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
	}
	public void scrollDown() {
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int starty = (int) (size.getHeight() * 0.80);
		int endy = (int) (size.getHeight() * 0.10);
		TouchAction t=new TouchAction(driver);
		t.press(PointOption.point(x, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo(PointOption.point(x, endy)).release().perform();
	}


}
