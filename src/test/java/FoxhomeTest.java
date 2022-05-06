import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FoxhomeTest {


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();

    }

    @Test
    public void openBrowser() {
        WebDriver driver = new ChromeDriver();
        driver.get(H.HOMEPAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void logIn() {
        WebDriver driver = new ChromeDriver();
        driver.get(H.HOMEPAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebElement logInBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.LOGINBTNXPATH)));
        logInBtn.click();
    }

    @Test
    public void logInUser() {
        WebDriver driver = new ChromeDriver();
        driver.get(H.HOMEPAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebElement logInBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.LOGINBTNXPATH)));
        logInBtn.click();
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.EMAILFIELDCSS)));
        WebElement passField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.PASSFIELDCSS)));
        WebElement register = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.REGISTERBTNCSS)));
        emailField.sendKeys("limors320@gmail.com");
        passField.sendKeys("Shiras156");
        register.click();

    }

    @Test
    public void loginUsers() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        for (int i = 0; i < H.EMAILFIELDARR.length; i++) {
            System.out.println("i = " + i);
            driver.get(H.HOMEPAGE);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.manage().window().maximize();
            WebElement logInBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.LOGINBTNXPATH)));
            logInBtn.click();
            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.EMAILFIELDCSS)));
            WebElement passField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.PASSFIELDCSS)));
            WebElement register = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.REGISTERBTNCSS)));
            emailField.sendKeys(H.EMAILFIELDARR[i]);
            Thread.sleep(3000);
            passField.sendKeys(H.PASSFIELDCSS);
            Thread.sleep(3000);
            register.click();
            String newURL = driver.getCurrentUrl();
            Assert.assertEquals("https://www.foxhome.co.il/", newURL);
            Thread.sleep(3000);
        }
        driver.quit();
    }


    @Test
    public void contactUs() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.HOMEPAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebElement contactUs = driver.findElement(By.cssSelector(H.CONTACTUSBTNCSS));
        contactUs.click();
        Thread.sleep(6000);
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(newUrl, H.CONTACTUSPAGE);
        driver.quit();

    }

    @Test
    public void storesLocation() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.HOMEPAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebElement storesLocation = driver.findElement(By.cssSelector(H.STORESLOCATIOBTNCSS));
        storesLocation.click();

    }


    @Test
    public void aboutUsBtn() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.HOMEPAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebElement aboutUsBtn = driver.findElement(By.xpath(H.ABOUTUSBTNXPATH));
        aboutUsBtn.click();
        Thread.sleep(3000);
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(newUrl, H.ABOUTUSPAGE);
        driver.quit();


    }

    @Test
    public void wishList() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.HOMEPAGE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.manage().window().maximize();
        WebElement logInBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.LOGINBTNXPATH)));
        logInBtn.click();
        WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.EMAILFIELDCSS)));
        WebElement passField = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.PASSFIELDCSS)));
        WebElement register = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.REGISTERBTNCSS)));
        emailField.sendKeys("limors320@gmail.com");
        passField.sendKeys("Shiras156");
        register.click();
        Thread.sleep(5000);
        WebElement wishlist = driver.findElement(By.partialLinkText(H.WISHLIST));
        wishlist.click();


        }
    }

