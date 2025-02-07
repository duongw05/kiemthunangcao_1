package anhtester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestSelenium {

    public static void main(String[] args) {
        // Cấu hình đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver-win32\\chromedriver.exe");

        // Tạo ChromeOptions (tuỳ chọn cấu hình Chrome)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");  // Mở cửa sổ trình duyệt tối đa
        options.addArguments("--disable-extensions");  // Tắt các extensions nếu cần

        // Khởi tạo browser với Chrome
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Thời gian chờ tìm phần tử

        try {
            // Mở trang anhtester.com
            driver.get("https://anhtester.com/");

            // Click nút Login
            driver.findElement(By.xpath("//a[@id='btn-login']")).click();

            // Đợi một chút để kiểm tra kết quả
            Thread.sleep(3000);  // Dừng 3 giây

        } catch (Exception e) {
            e.printStackTrace();  // In ra lỗi nếu có
        } finally {
            // Tắt browser sau khi chạy xong
            driver.quit();
        }
    }
}
