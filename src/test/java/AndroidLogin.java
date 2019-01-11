//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class AndroidLogin {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "89UDU18406001981");
//        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "rs.assecosee.MCMobileAppDroid.test");
//        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "md50ff3ffa2d67dcdff3917ffd52fcc09d4.SplashActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4726/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void login() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='PinBoxesTestUI']")));
        driver.findElement(By.xpath("//*[@contentDescription='PinBoxesTestUI']")).click();
        driver.findElement(By.xpath("//*[@text='2']")).click();
        driver.findElement(By.xpath("//*[@text='2']")).click();
        driver.findElement(By.xpath("//*[@text='3']")).click();
        driver.findElement(By.xpath("//*[@text='3']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Po\u010detni ekran']")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
