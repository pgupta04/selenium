package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ZeeDilSeJavaAutomation2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.zeedilse.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testZeeDilSeJavaAutomation2() throws Exception {
    driver.get(baseUrl + "/register");
    driver.findElement(By.id("clientUser_first_name")).clear();
    driver.findElement(By.id("clientUser_first_name")).sendKeys("Shantanu");
    driver.findElement(By.id("clientUser_last_name")).clear();
    driver.findElement(By.id("clientUser_last_name")).sendKeys("Guha");
    driver.findElement(By.id("clientUserEmail_email")).clear();
    driver.findElement(By.id("clientUserEmail_email")).sendKeys("shantanu_guha@gmail.com");
    driver.findElement(By.id("clientUser_password")).clear();
    driver.findElement(By.id("clientUser_password")).sendKeys("guha12345");
    driver.findElement(By.id("clientUserLocation_postal_code")).clear();
    driver.findElement(By.id("clientUserLocation_postal_code")).sendKeys("75015");
    new Select(driver.findElement(By.id("clientUser_birthMonth"))).selectByVisibleText("August");
    new Select(driver.findElement(By.id("clientUser_birthDay"))).selectByVisibleText("10");
    new Select(driver.findElement(By.id("clientUser_birthYear"))).selectByVisibleText("1983");
    driver.findElement(By.id("clientUser_terms")).click();
    driver.findElement(By.id("clientUser_gender_0")).click();
    driver.findElement(By.name("yt0")).click();
    driver.findElement(By.name("yt0")).click();
    driver.findElement(By.id("subNavContestantVideos")).click();
    driver.findElement(By.linkText("Highest Rated")).click();
    driver.findElement(By.xpath("//div[@id='posts']/div/div[2]/div/a/img")).click();
    driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();
    driver.findElement(By.id("linkProfile")).click();
    driver.findElement(By.linkText("Log Out")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
