import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("Amazon.com sitesine girilir")
    public void amazonComSitesineGirilir() {
        driver.get("https://amazon.com/");
    }

    @When("Search bar a {string} yazılır")
    public void searchBarAYazılır(String key) {
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(key);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);

    }

    @Then("SSD arama {string} görüntülenir")
    public void ssdAramaGörüntülenir(String key) throws InterruptedException {
        Thread.sleep(1000);
        String path = "//span[contains(text(),'" + key + "')]";
        Assert.assertTrue(driver.findElement(By.xpath(path)).getText().contains(key));
    }
}
