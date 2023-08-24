package RandD;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeForTesting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.setBinary("C:\\Users\\user\\Downloads\\chrome-win64 (1)\\chrome-win64\\chrome.exe");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }
}
