package RandD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementExtraction {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--selenium-manager true");
//        options.setBrowserVersion(System.getenv("116.0.5845.97"));
        WebDriver driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        WebElement search= driver.findElement(By.xpath("//textarea[@name='q']"));
        String SearchXpath= String.valueOf(search);
        System.out.println(search);
        System.out.println(SearchXpath);
//        String xpath="[[ChromeDriver: chrome on windows (a811e9b5f79fde3020584392a284100e)] -> xpath: //textarea[@name='q']]";
        String xpath=SearchXpath.substring(80,SearchXpath.length()-1);
        System.out.println(xpath);
        System.out.println(SearchXpath.length());
        driver.findElement(By.xpath(xpath)).sendKeys("Google");
//        driver.quit();
    }
}
