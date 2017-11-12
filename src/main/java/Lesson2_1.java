import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson2_1 {
    public static final String CONTENT_TITLE = ".//*[@id='content']/div[1]/div/h2";

    // only for MODULES and for CATALOGUE
    public static final String MAIN_DIV_TITLE = ".//*[@id='main-div']/div[1]/h2";

    public static final String DASHBOARD = ".//*[@id='tab-AdminDashboard']/a";
    public static final String ORDERS = ".//*[@id='subtab-AdminParentOrders']/a";
    public static final String CATALOGUE = ".//*[@id='subtab-AdminCatalog']/a";
    public static final String CLIENTS = "/html/body/nav/ul/li[5]/a";
    public static final String CLIENTSERVICE = ".//*[@id='subtab-AdminParentCustomerThreads']/a";
    public static final String STATISTIC = ".//*[@id='subtab-AdminStats']/a";
    public static final String MODULES = ".//*[@id='subtab-AdminParentModulesSf']/a";
    public static final String DESIGN = "/html/body/nav/ul/li[10]/a";

    //public static final String DESIGN = ".//*[@id='subtab-AdminParentThemes']/a";
    public static final String DELIVERY = ".//*[@id='subtab-AdminParentShipping']/a";
    public static final String PAYMENT = ".//*[@id='subtab-AdminParentPayment']/a";
    public static final String INTERNATIONAL = ".//*[@id='subtab-AdminInternational']/a";
    public static final String SHOPPARAMETERS = ".//*[@id='subtab-ShopParameters']/a";
    public static final String ADMINADVANCEDPARAMETERS = ".//*[@id='subtab-AdminAdvancedParameters']/a";




    public static void main (String [] args){
        Lesson2_1 lesson2_1 = new Lesson2_1();
        List<String> menuLinksArray = new ArrayList<String>();
        Map<String, String> etalonTitlesMap = new HashMap<String, String>();
        menuLinksArray.add(DASHBOARD);
        menuLinksArray.add(ORDERS);
        menuLinksArray.add(CATALOGUE);
        menuLinksArray.add(CLIENTS);
        menuLinksArray.add(CLIENTSERVICE);
        menuLinksArray.add(STATISTIC);
        menuLinksArray.add(MODULES);
        menuLinksArray.add(DESIGN);
        menuLinksArray.add(DELIVERY);
        menuLinksArray.add(PAYMENT);
        menuLinksArray.add(INTERNATIONAL);
        menuLinksArray.add(SHOPPARAMETERS);
        menuLinksArray.add(ADMINADVANCEDPARAMETERS);



        WebDriver driver = initChrome();
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        lesson2_1.enterPassword (driver, "webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        lesson2_1.threadSleep(3000);

/*        System.out.println(lesson2_1.getTitle(driver, ORDERS, CONTENT_TITLE));
        driver.navigate().refresh();
        lesson2_1.threadSleep(1000);
        System.out.println(lesson2_1.getOnlyTitle(driver, CONTENT_TITLE));

        System.out.println("CATALOGUE1");
        System.out.println(lesson2_1.getTitle(driver, CATALOGUE, MAIN_DIV_TITLE));
        driver.navigate().refresh();
        lesson2_1.threadSleep(1000);
        System.out.println("CATALOGUE2");
        System.out.println(lesson2_1.getOnlyTitle(driver, MAIN_DIV_TITLE));

        System.out.println("CLIENTS1");
        System.out.println(lesson2_1.getTitle(driver, "/html/body/nav/ul/li[5]/a", CONTENT_TITLE));
        driver.navigate().refresh();
        lesson2_1.threadSleep(1000);
        System.out.println("CCLIENTS2");
        System.out.println(lesson2_1.getOnlyTitle(driver, CONTENT_TITLE));*/


        for (String menuName : menuLinksArray) {
            String changeTitleName;
            System.out.println(menuName + " 1time");

            if (menuName.equals(MODULES) | menuName.equals(CATALOGUE)) {
                changeTitleName = MAIN_DIV_TITLE;
            } else {
                changeTitleName = CONTENT_TITLE;
            }

            System.out.println(lesson2_1.getTitle(driver, menuName, changeTitleName));
            driver.navigate().refresh();
            lesson2_1.threadSleep(1000);
            System.out.println(menuName + " 2time");
            System.out.println(lesson2_1.getOnlyTitle(driver, changeTitleName));


        }

        //lesson2_1.exitPage(driver);
        //driver.quit();
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

    public String getTitle (WebDriver driver, String pathMenueItem, String pathTile){
        WebElement webElement = driver.findElement(By.xpath(pathMenueItem));
        webElement.click();
        threadSleep(3000);
        WebElement webElementTitle = driver.findElement(By.xpath(pathTile));
        return webElementTitle.getText();

    }

    public String getOnlyTitle (WebDriver driver, String pathTile){
        WebElement webElementTitle = driver.findElement(By.xpath(pathTile));
        return webElementTitle.getText();

    }


    public void threadSleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


/*
        // WebElement dashboard = driver.findElement(By.className("page-title"));
        List <WebElement> weblist =  driver.findElement(By.tagName ("Ol")).findElements(By.className("b_algo"));
        System.out.println(weblist.size());*/