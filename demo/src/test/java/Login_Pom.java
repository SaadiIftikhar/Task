import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Pom {
    private WebDriver driver;
    private WebDriverWait wait;

    public Login_Pom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void goToWebsite(String url) {
        driver.get(url);
    }

    public void changeLanguage() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Menu']")));
        menu.click();
        driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > span:nth-child(1)")).click();
    }

    public void login(String username, String password) {
        WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username")));
        uname.sendKeys(username);
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
        pass.sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > a:nth-child(2) > button:nth-child(1)")));
    }
}
