package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	public HomePage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/text1")
	public WebElement country;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	public WebElement nametextbox;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	public WebElement malegenderradiobutton;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	public WebElement femalegenderradiobutton;
	
	@AndroidFindBy(xpath="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> products;

}
