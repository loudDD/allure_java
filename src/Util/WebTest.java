package Util;import io.qameta.allure.Attachment;import org.openqa.selenium.OutputType;import org.openqa.selenium.TakesScreenshot;import org.openqa.selenium.WebDriver;import org.openqa.selenium.chrome.ChromeDriver;import org.testng.annotations.AfterClass;import org.testng.annotations.BeforeClass;import org.testng.annotations.Listeners;import java.io.File;@Listeners({TestngListener.class})public class WebTest {    public WebDriver getWebDriver(){        String rootPath = System.getProperty("user.dir");        System.setProperty("webdriver.chrome.driver", rootPath + File.separator + "driver" + File.separator+"chromedriver.exe");        WebDriver driver = new ChromeDriver();        return driver;    }    @BeforeClass    public void setUp(){        System.setProperty("webdriver.chrome.driver","resource/chromedriver.exe");        WebDriver driver = new ChromeDriver();    }    @AfterClass    public void tearDown(){        getWebDriver().quit();    }    @Attachment(value = "screen shot",type = "image/png")    public byte[]  takePhoto(){        byte[] screenshotAs = ((TakesScreenshot)getWebDriver()).getScreenshotAs(OutputType.BYTES);        return screenshotAs;    }    @Attachment    public byte[] get(String url){        getWebDriver().navigate().to(url);        return takePhoto();    }}