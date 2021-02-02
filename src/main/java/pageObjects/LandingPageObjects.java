package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPageObjects {
	public LandingPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.nobroker.app:id/yesPhoneState")
	public WebElement permissioncontinue;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	public WebElement allowlocation;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public WebElement allowcontacts;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_button")
	public WebElement allowcalls;
	
	@AndroidFindBy(id="com.nobroker.app:id/buyLayoutText")
	public WebElement buy;
	
	@AndroidFindBy(id="com.nobroker.app:id/searchEditHome")
	public WebElement searchbox;

}
