package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileTests {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("fullReset", "false");
        desiredCapabilities.setCapability("noReset", "false");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\egeme\\Downloads\\MyFitnessPal.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void Login() throws InterruptedException {
        Thread.sleep(15000);
        MobileElement el1 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/buttonLogIn");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/email_address_edit");
        el2.sendKeys("caliadeathfire@gmail.com");
        MobileElement el3 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/password_edit");
        el3.sendKeys("sifre12345");
        MobileElement el4 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/login_button");
        el4.click();
        Thread.sleep(18000);
        MobileElement el5 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/imageClose");
        el5.click();
        MobileElement ele= (MobileElement) driver.findElementById("com.myfitnesspal.android:id/feature_highlight_description");
        ele.click();
        Thread.sleep(5000);

        MobileElement el6 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"MainActivity\"]/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        Assert.assertTrue(el6.getText().contains("Calories Remaining"));

    }
    @Test
    public void AddFood() {
        MobileElement el1 = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Diary\"]/android.widget.ImageView");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/add_food");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/searchEditText");
        el3.click();
        el3.sendKeys("pirzola");
        MobileElement el4 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/searchForTextView");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"FoodSearchActivityV2\"]/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/noOfServingsTableRow");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/numOfServings");
        el7.sendKeys("2");
        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementByAccessibilityId("Add");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.myfitnesspal.android:id/txtItemDescription");
        Assert.assertTrue(el10.getText().contains("Kuzu Pirzola"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
