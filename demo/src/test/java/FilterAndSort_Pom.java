import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterAndSort_Pom {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public FilterAndSort_Pom(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
    }

    // Method to check Sort and filter
    public void checkSort() throws InterruptedException 
    {

        //Chnage to 50 
        WebElement paginationDrop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":ra:")));
        paginationDrop.click();
        WebElement paginationSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-value='50']")));
        paginationSelect.click();
        Thread.sleep(2000);

        //Get first email
        List<WebElement> emaillist = driver.findElements(By.xpath("//tr//th[3]"));
        List <String> first = emaillist.stream().map(s->s.getText()).collect(Collectors.toList());
        String firstEmail = first.get(1);

        //Before Sort
        List<WebElement> beforeElements = driver.findElements(By.xpath("//tr//th[1]"));
        List <String> originallist = beforeElements.stream().map(s->s.getText()).collect(Collectors.toList());

        //Using Sort
        WebElement cfilter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[@data-sort='POLICY_NUMBER']//*[name()='svg']")));
        cfilter.click();
        Thread.sleep(2000);

        //After Sort
        List<WebElement> afterElements = driver.findElements(By.xpath("//tr//th[1]"));
        List <String> afterSort = afterElements.stream().map(s->s.getText()).collect(Collectors.toList());

        //Compare Lists

        String lastItem = originallist.getLast();
        String firstItem = afterSort.get(1);
        Assert.assertEquals("String should be same", lastItem, firstItem);

        //Click Search
        WebElement searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role=\"combobox\"]")));
        searchbar.click();

        //Select Email
        WebElement searchEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-value='email']")));
        searchEmail.click();
        Thread.sleep(3000);

        //Seach Email
   
        
        WebElement inputEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        inputEmail.sendKeys(firstEmail);
        WebElement inputEnter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='"+firstEmail+"']")));
        inputEnter.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        ////Verification
        List<WebElement> emailListAfter = driver.findElements(By.xpath("//tr//th[3]"));
        List <String> second = emailListAfter.stream().map(s->s.getText()).collect(Collectors.toList());
        String emailone = second. get(1);
        String emailtwo = second.getLast();
        Assert.assertEquals("String should be same", emailone, emailtwo);

    }
}
