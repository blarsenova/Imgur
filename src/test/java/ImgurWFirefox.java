import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImgurWFirefox {


    WebDriver driver;
    Actions actions;


    @BeforeClass
    public void setUpClass() {
        WebDriverManager.firefoxdriver().setup();


    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://imgur.com");

    }

    @Test
    public void uploadWSelenium() throws InterruptedException {

        /*New Post:
        Make sure u can upload an image and it takes you
        to that page after
         */


        driver.findElement(By.linkText("New post")).click();

        WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(3000);
        upload.sendKeys("/Users/baktygullarsenova/Downloads/spring.jpg");


    }


    @Test
    public void search() throws Exception {
        /*Search:
        Make sure u can search
        & the results are tied up
        to your query
         */

        //driver.get("http://imgur.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("flowers" + Keys.ENTER);
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("flowers"));
    }

    @Test
    public void randomMode() throws InterruptedException {
    /* Random mode function:
    make sure random button works
    and takes you
    to the new page successfully
     */

        //Select dropdrowns=new Select(driver.findElement(By.className("Dropdown-title")));
        driver.findElement(By.xpath("//div[@class='Dropdown sort Dropdown--upper']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='Dropdown-list']/div[3]")).click();




    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();


    }
}
