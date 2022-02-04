package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import tests.drivers.ConfigReader;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumProject {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\asusx\\Desktop\\Selenium\\src\\tests\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(ConfigReader.getProperty("Url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expectedTitle="https://www.chanel.com/us/";
        if(expectedTitle.equals(driver.getCurrentUrl())){
            System.out.println("Accès OK");
        }
        else{
            System.out.println("Accès  Failled");
        }


        driver.findElement(By.xpath("//button[@data-test='btnSearch_Header_Disabled']")).click();
        WebElement search2 = driver.findElement(By.xpath("//input[@aria-describedby='search-describedby']"));
        search2.sendKeys("ROUGE ALLURE"+Keys.ENTER);

        Thread.sleep(3000);

     List<WebElement>VerifyRougeAllure =driver.findElements(By.tagName("h4"));
     for (WebElement s: VerifyRougeAllure
             ) {
            System.out.println(s.getText());

        }


        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//span[text()='Ref. 151247']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click().perform();

        String rougeAllureExpected ="ROUGE ALLURE VELVET LE LION DE CHANEL";
        WebElement rougeAllure =driver.findElement(By.xpath("//span[text()='ROUGE ALLURE VELVET LE LION DE CHANEL']"));
        if(rougeAllure.getText().equals(rougeAllureExpected)){
            System.out.println("Pass : "+rougeAllure.getText());
        }

        else {
            System.out.println("false");
        }


        driver.findElement(By.xpath("//img[@data-test='lnkLogo']")).click();
        driver.findElement(By.xpath("//span[text()='Makeup']")).click();
        driver.findElement(By.partialLinkText("Lipstick")).click();
        Thread.sleep(3000);
        WebElement rougeMove= driver.findElement(By.xpath("//span[text()='Add to bag']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,2000)");

        Thread.sleep(2000);

        WebElement addToBag = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div[2]/div/div[2]/div[1]/div[7]/article/div[2]/div[2]/div[2]/button[2]/span/span"));
        actions.doubleClick(addToBag).perform();
        driver.findElement(By.xpath("/html/body/div[16]/div/div[3]/div[1]/div[6]/form/ul/li/p/button/span")).click();

      WebElement expectedDATA = driver.findElement(By.xpath("//a[@data-test='secProductName_0']"));
      if(expectedDATA.isDisplayed()){
          System.out.println("pass");
      }

















    }
}
