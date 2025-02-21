import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomationTest {
    @Test
    void testAutomation() {
        WebDriverManager.chromedriver().setup(); // Tự động tải và cấu hình driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://vitimex.com.vn/");

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Áo Sơ Mi");
        searchBox.submit();

        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Thêm vào giỏ hàng')]"));
        addToCartButton.click();

        driver.quit();
    }
}
