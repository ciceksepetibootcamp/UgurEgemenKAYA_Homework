// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class DiscountValidationTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\egeme\\Downloads\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void discountValidation() throws InterruptedException {
    driver.get("https://www.ciceksepeti.com/");
    driver.manage().window().setSize(new Dimension(1050, 708));
    Thread.sleep(2000);
    driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]")).click();
    driver.findElement(By.cssSelector(".slick-slide:nth-child(5) .brand-slider-image")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/main[1]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[3]/div[1]/span[1]")));
    }
    vars.put("discount", driver.findElement(By.xpath("//body/main[1]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[3]/div[1]/span[1]")).getText());
    driver.findElement(By.cssSelector(".products__item:nth-child(1) .products__item-img")).click();
    vars.put("detaildisc", driver.findElement(By.xpath("//body/main[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]")).getText());
    assertEquals(vars.get("discount").toString(), vars.get("detaildisc").toString());
  }

  @Test
  public void SellerToolTipTest() throws InterruptedException {
    driver.get("https://www.ciceksepeti.com/");
    driver.manage().window().setSize(new Dimension(1050, 708));
    Thread.sleep(2000);

    driver.findElement(By.xpath("//body/main[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//body/div[4]/div[2]/span[1]")).click();
    driver.findElement(By.xpath("//body/main[1]/div[1]/div[3]/div[1]/div[1]/a[1]/picture[1]/img[1]")).click();
    driver.findElement(By.xpath("//body/main[1]/div[1]/div[4]/div[1]/div[1]/div[1]/a[1]/div[1]/img[1]")).click();
    {
      WebElement element = driver.findElement(By.xpath("//body/main[1]/form[1]/div[1]/div[1]/div[2]/div[2]/div[5]/div[12]/span[2]/span[1]/span[1]"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product__seller-info:nth-child(16) .product__seller-tooltip-text")));
    }
  }
}
