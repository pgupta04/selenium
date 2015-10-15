import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.Select;

public class ZeeDilSeJavaAutomation1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//    baseUrl = "https://www.zeedilse.com";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  //@Test
  public void testZeeDilSeJavaAutomation1() throws Exception {
      driver = new FirefoxDriver();
      baseUrl = "https://www.zeedilse.com";
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


      driver.get(baseUrl + "/register");
    driver.findElement(By.id("clientUser_first_name")).clear();
    driver.findElement(By.id("clientUser_first_name")).sendKeys("Payal");
    driver.findElement(By.id("clientUser_last_name")).clear();
    driver.findElement(By.id("clientUser_last_name")).sendKeys("Sharma");
    driver.findElement(By.id("clientUserEmail_email")).clear();
    driver.findElement(By.id("clientUserEmail_email")).sendKeys("payal.Sharma@gmail.com");
    driver.findElement(By.id("clientUser_password")).clear();
    driver.findElement(By.id("clientUser_password")).sendKeys("parveen123");
    driver.findElement(By.id("clientUserLocation_postal_code")).clear();
    driver.findElement(By.id("clientUserLocation_postal_code")).sendKeys("77036");
    new Select(driver.findElement(By.id("clientUser_birthMonth"))).selectByVisibleText("June");
    new Select(driver.findElement(By.id("clientUser_birthDay"))).selectByVisibleText("28");
    new Select(driver.findElement(By.id("clientUser_birthYear"))).selectByVisibleText("1979");
    driver.findElement(By.id("clientUser_gender_1")).click();
    driver.findElement(By.id("clientUser_terms")).click();
    driver.findElement(By.name("yt0")).click();
    Thread.sleep(5000);

      driver.findElement(By.id("linkProfile")).click();
      driver.findElement(By.id("clientUserEmail_active_1")).click();
      driver.findElement(By.name("yt0")).click();

      Thread.sleep(5000);

    driver.get("https://www.zeedilse.com/play/2db0ac402db8577478685080ea9b8c84");
//    driver.findElement(By.id("subNavContestantVideos")).click();
//    driver.findElement(By.linkText("Highest Rated")).click();
    //driver.findElement(By.xpath("//div[@id='posts']/div/div[4]/div/a/img")).click();
    driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();

      Thread.sleep(5000);
      driver.get("https://www.zeedilse.com/play/f716d6109ab3cd006144899614a4b854");
      driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();

      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
      }

  }

    //@Test
    public void testZeeDilSeJavaAutomation2() throws Exception {
        List<User> users = ReadExcelFileExample.getUserListFromExcel();
        for(User user:users) {

            driver = new FirefoxDriver();

            baseUrl = "https://www.zeedilse.com";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(baseUrl + "/register");

            // Create User
            driver.findElement(By.id("clientUser_first_name")).clear();
            driver.findElement(By.id("clientUser_first_name")).sendKeys(user.getFirstName());
            driver.findElement(By.id("clientUser_last_name")).clear();
            driver.findElement(By.id("clientUser_last_name")).sendKeys(user.getLastName());
            driver.findElement(By.id("clientUserEmail_email")).clear();
            driver.findElement(By.id("clientUserEmail_email")).sendKeys(user.getEmail());
            driver.findElement(By.id("clientUser_password")).clear();
            driver.findElement(By.id("clientUser_password")).sendKeys(user.getPassword());
            driver.findElement(By.id("clientUserLocation_postal_code")).clear();
            driver.findElement(By.id("clientUserLocation_postal_code")).sendKeys(user.getZipCode());
            new Select(driver.findElement(By.id("clientUser_birthMonth"))).selectByVisibleText(user.getBirthMonth());
            new Select(driver.findElement(By.id("clientUser_birthDay"))).selectByVisibleText(user.getBirthDay());
            new Select(driver.findElement(By.id("clientUser_birthYear"))).selectByVisibleText(user.getBirthYear());
            driver.findElement(By.id("clientUser_gender_1")).click();
            driver.findElement(By.id("clientUser_terms")).click();
            driver.findElement(By.name("yt0")).click();
            //wait for 5 seconds
            Thread.sleep(5000);

            // Inactivate emails
            driver.findElement(By.id("linkProfile")).click();
            driver.findElement(By.id("clientUserEmail_active_1")).click();
            driver.findElement(By.name("yt0")).click();
            Thread.sleep(5000);

            // Redirect to URL and vote
            driver.get("https://www.zeedilse.com/play/2db0ac402db8577478685080ea9b8c84");
            driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();
            Thread.sleep(5000);

            // Redirect to URL and vote
            driver.get("https://www.zeedilse.com/play/f716d6109ab3cd006144899614a4b854");
            driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();
            Thread.sleep(5000);

            // Logout
            driver.findElement(By.id("linkProfile")).click();
            driver.findElement(By.linkText("Log Out")).click();

            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }

        }
    }


    //@Test
    public void testZeeDilSeJavaAutomation3() throws Exception {
        List<User> users = ReadExcelFileExample.getUserListFromExcel2();
        for(User user:users) {

            driver = new FirefoxDriver();

            baseUrl = "https://www.zeedilse.com";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(baseUrl + "/register");

            // Create User
            driver.findElement(By.id("clientUser_first_name")).clear();
            driver.findElement(By.id("clientUser_first_name")).sendKeys(user.getFirstName());
            driver.findElement(By.id("clientUser_last_name")).clear();
            driver.findElement(By.id("clientUser_last_name")).sendKeys(user.getLastName());
            driver.findElement(By.id("clientUserEmail_email")).clear();
            driver.findElement(By.id("clientUserEmail_email")).sendKeys(user.getEmail());
            driver.findElement(By.id("clientUser_password")).clear();
            driver.findElement(By.id("clientUser_password")).sendKeys(user.getPassword());
            driver.findElement(By.id("clientUserLocation_postal_code")).clear();
            driver.findElement(By.id("clientUserLocation_postal_code")).sendKeys(user.getZipCode());
            new Select(driver.findElement(By.id("clientUser_birthMonth"))).selectByVisibleText(user.getBirthMonth());
            new Select(driver.findElement(By.id("clientUser_birthDay"))).selectByVisibleText(user.getBirthDay());
            new Select(driver.findElement(By.id("clientUser_birthYear"))).selectByVisibleText(user.getBirthYear());
            if(user.getGender().equalsIgnoreCase("Male")) {
                driver.findElement(By.id("clientUser_gender_0")).click();
            } else {
                driver.findElement(By.id("clientUser_gender_1")).click();
            }
            driver.findElement(By.id("clientUser_terms")).click();
            driver.findElement(By.name("yt0")).click();
            //wait for 5 seconds
            Thread.sleep(5000);

            // Inactivate emails
            driver.findElement(By.id("linkProfile")).click();
            driver.findElement(By.id("clientUserEmail_active_1")).click();
            driver.findElement(By.name("yt0")).click();
            Thread.sleep(5000);

            // Redirect to URL and vote
            driver.get("https://www.zeedilse.com/play/2db0ac402db8577478685080ea9b8c84");
            driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();
            Thread.sleep(5000);

            // Redirect to URL and vote
            driver.get("https://www.zeedilse.com/play/f716d6109ab3cd006144899614a4b854");
            driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();
            Thread.sleep(5000);

            // Logout
            driver.findElement(By.id("linkProfile")).click();
            driver.findElement(By.linkText("Log Out")).click();

            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }

        }
    }

    @Test
    public void testZeeDilSeJavaAutomation4() throws Exception {
        final Random random = new Random();
        final int seed = 300*1000;

        List<User> users = ReadExcelFileExample.getUserListFromExcel2();
        for(User user:users) {

            int time = random.nextInt(seed);
            System.out.println("Going to sleep for "+time/1000+" seconds");
            Thread.sleep(time);
            System.out.println("Working for "+user.getEmail());

            driver = new FirefoxDriver();

            baseUrl = "https://www.zeedilse.com";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(baseUrl + "/register");

            // Create User
            driver.findElement(By.id("clientUser_first_name")).clear();
            driver.findElement(By.id("clientUser_first_name")).sendKeys(user.getFirstName());
            driver.findElement(By.id("clientUser_last_name")).clear();
            driver.findElement(By.id("clientUser_last_name")).sendKeys(user.getLastName());
            driver.findElement(By.id("clientUserEmail_email")).clear();
            driver.findElement(By.id("clientUserEmail_email")).sendKeys(user.getEmail());
            driver.findElement(By.id("clientUser_password")).clear();
            driver.findElement(By.id("clientUser_password")).sendKeys(user.getPassword());
            driver.findElement(By.id("clientUserLocation_postal_code")).clear();
            driver.findElement(By.id("clientUserLocation_postal_code")).sendKeys(user.getZipCode());
            new Select(driver.findElement(By.id("clientUser_birthMonth"))).selectByVisibleText(user.getBirthMonth());
            new Select(driver.findElement(By.id("clientUser_birthDay"))).selectByVisibleText(user.getBirthDay());
            new Select(driver.findElement(By.id("clientUser_birthYear"))).selectByVisibleText(user.getBirthYear());
            if(user.getGender().equalsIgnoreCase("Male")) {
                driver.findElement(By.id("clientUser_gender_0")).click();
            } else {
                driver.findElement(By.id("clientUser_gender_1")).click();
            }
            driver.findElement(By.id("clientUser_terms")).click();
            driver.findElement(By.name("yt0")).click();
            //wait for 5 seconds
            Thread.sleep(5000);

            // Inactivate emails
            driver.findElement(By.id("linkProfile")).click();
            driver.findElement(By.id("clientUserEmail_active_1")).click();
            driver.findElement(By.name("yt0")).click();
            Thread.sleep(5000);

            // Redirect to URL and vote
            //driver.get("https://www.zeedilse.com/play/2db0ac402db8577478685080ea9b8c84");
            //driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();
            //Thread.sleep(5000);

            // Redirect to URL and vote
            driver.get("https://www.zeedilse.com/play/f716d6109ab3cd006144899614a4b854");
            driver.findElement(By.xpath("//span[@id='stars']/a[5]/img")).click();
            Thread.sleep(5000);

            // Logout
            driver.findElement(By.id("linkProfile")).click();
            driver.findElement(By.linkText("Log Out")).click();

            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }

        }
    }

    @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
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
