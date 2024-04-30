import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImportInsurance_Pom {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ImportInsurance_Pom(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
    }

    // Method to click on the "Weiter zur Bezahlung" button
    public void clickImport() {
        WebElement cimport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Import')]")));
        cimport.click();
    }

    public void uploadCSV(String filePath) 
    {
    File uploadFile = new File("src/testdata/testdata.csv");
    WebElement fileInput = driver.findElement(By.id("input-csv"));
    fileInput.sendKeys(uploadFile.getAbsolutePath());
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(., 'PDCODE617842')]")));
    }

    // Click Create Insurance
    public void createInsuracne() {
        WebElement createInsurance = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create insurance']")));
        createInsurance.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='alert']")));
    }

    
}
