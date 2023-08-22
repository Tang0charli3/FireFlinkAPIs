package RandD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectByText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
//        options.setBrowserVersion(System.getenv("116.0.5845.97"));
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pantaloons.com/c/women/kurtas-6848");
        String text=driver.findElement(By.xpath("//select[@class='MuiSelect-root MuiSelect-select MuiInputBase-input MuiInput-input']")).getText();
        System.out.println(text);
        Select select=new Select(driver.findElement(By.xpath("//select[@class='MuiSelect-root MuiSelect-select MuiInputBase-input MuiInput-input']")));
        select.selectByVisibleText(" Latest");
        driver.quit();
    }
}
