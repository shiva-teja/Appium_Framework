package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPageObjects {
	public SearchPageObjects(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.nobroker.app:id/spinnergo")
	public WebElement citydropdown;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Bangalore']")
	public WebElement selectcity;
	
	
	@AndroidFindBy(id="com.nobroker.app:id/localityAutoCompleteTxt")
	public WebElement localitytextbox; 
	
	@AndroidFindBy(id="com.nobroker.app:id/nearByRadio")
	public WebElement nearbycheckbox;
	
	@AndroidFindBy(id="com.nobroker.app:id/bhktwo")
	public WebElement twobhk;
	
	@AndroidFindBy(id="com.nobroker.app:id/bhkthree")
	public WebElement threebhk;
	
	@AndroidFindBy(id="com.nobroker.app:id/searchProperty")
	public WebElement searchpropertybutton;

}
