package io.appium.java_client.android;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class NewTest {
	private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "2f12d624");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.app.pepperfry");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".home.main.ui.SplashScreenActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() throws InterruptedException {
    	Thread.sleep(30);
    	// driver.tap(1, driver.findElement(By.xpath("//*[@text='SKIP IT FOR NOW']")),1);
         
    	 //driver.tap(1,driver.findElement(By.xpath("//*[@text='OKAY, GOT IT']")),1);
        driver.findElement(By.xpath("//*[@id='ivIcon' and (./preceding-sibling::* | ./following-sibling::*)[@text='Furniture']]")).click();
        new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ivThumbnail' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.LinearLayout' and ./*[@text='3 DOOR WARDROBES']]]")));
        driver.findElement(By.xpath("//*[@id='ivThumbnail' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.LinearLayout' and ./*[@text='3 DOOR WARDROBES']]]")).click();
        driver.findElement(By.xpath("//*[@id='arImage' and (./preceding-sibling::* | ./following-sibling::*)[@text='Yukiko Three Door Wardrobe in Wenge Finish by Mintwud']]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ALLOW']")));
        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
        driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
        driver.findElement(By.xpath("//*[@id='click']")).click();
        driver.findElement(By.xpath("//*[@id='thumbnail_preview']")).click();
        driver.findElement(By.xpath("(//*[@id='frame']/*[@class='android.widget.ImageView'])[3]")).click();
        driver.findElement(By.xpath("//*[@text='WALL VIEW']")).click();
        //driver.swipe(652, 555, 580, 730, 937);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
