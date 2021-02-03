package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PropertiesPageObjects {
	public PropertiesPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.nobroker.app:id/property_thumbnail")
	public List <WebElement> properties;
	
	@AndroidFindBy(id="com.nobroker.app:id/tv_report_wrong_info")
	public List <WebElement> wronginfo;
	
	@AndroidFindBy(id="com.nobroker.app:id/tv_report_wrong_info")
	public WebElement wronginfobutton; 

}
