//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class IOSLogin {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability("bundleId", "rs.mts.banka.test");
        dc.setCapability(MobileCapabilityType.UDID, "86690fa0983f87b47334eb08b958e4d64c696b9f");
        dc.setCapability("unicodeKeyboard", "true");
        driver = new IOSDriver<>(new URL("http://localhost:4726/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void login() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@knownSuperClass='UILabel']")));
        driver.findElement(By.xpath("//*[@knownSuperClass='UILabel']")).click();
        driver.findElement(By.xpath("//*[@text='2']")).click();
        driver.findElement(By.xpath("//*[@text='2']")).click();
        driver.findElement(By.xpath("//*[@text='3']")).click();
        driver.findElement(By.xpath("//*[@text='3']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Početni ekran']")));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}