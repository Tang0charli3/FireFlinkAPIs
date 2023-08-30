package RandD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class ChromeForTesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options=new ChromeOptions();
//        options.setBinary("C:\\Users\\user\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.pantaloons.com/");
//        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
        Set cookies=driver.manage().getCookies();
        System.out.println(cookies.toString());
        driver.quit();
    }
}
