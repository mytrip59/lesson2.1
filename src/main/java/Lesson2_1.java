import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson2_1 {

    public static void main (String [] args){
        Lesson2_1 lesson2_1 = new Lesson2_1();

        WebDriver driver = initChrome();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        lesson2_1.enterPassword (driver, "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        lesson2_1.threadSleep(3000);

        lesson2_1.exitPage(driver);
        driver.quit();
    }

    public static WebDriver initChrome (){
        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\lesson2\\lesson2\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }

    public void enterPassword (WebDriver driver, String log, String pas){
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys(log);
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys(pas);
        WebElement button = driver.findElement(By.name ("submitLogin"));
        button.click();
    }

    public static void exitPage (WebDriver driver){
        WebElement webElement = driver.findElement(By.xpath(".//*[@id='employee_infos']/a"));
        webElement.click();
        WebElement exit = driver.findElement(By.xpath(".//*[@id='header_logout']"));
        exit.click();
    }

    public void threadSleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
