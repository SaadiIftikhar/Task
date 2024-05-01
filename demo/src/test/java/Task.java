import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Listeners;


@Listeners(CustomTestListener.class)
public class Task 
{

    @Test(description = "Create a single Insurance Policy", priority = 1)
    public void First() 
    {
        WebDriver driver = null;
        try {
            // Set up WebDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Create instance of LoginPage
            Login_Pom loginpom = new Login_Pom(driver);

            // Create an instance of InsurancePage
            AddInsurance_Pom insurancePage = new AddInsurance_Pom(driver);

            // Login
            loginpom.goToWebsite("https://insurance-manager.sb-qa-candidatetask.sisu.sh/login");
            loginpom.changeLanguage();
            loginpom.login("testsellingpartner1@simplesurance.de", "TestSellingPartner1Pass");
            
            

            // Add Insurance
            insurancePage.addInsurance();

            
        } 
        
        catch (Exception e) 
        {
            throw new RuntimeException("Create a single Insurance Policy: " + e.getMessage(), e);
        } 
        
        finally 
        {
            // Close the browser session
            if (driver != null) 
            {
               driver.quit();
            }
        }
    }

    @Test(description = "Create batch/multiple Insurance Policy using provided CSV file", priority = 2)
    public void Second() 
    {
        WebDriver driver = null;
        try {
            // Set up WebDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Create instance of LoginPage
            Login_Pom loginpom = new Login_Pom(driver);

            // Create instance of InsurancePage
            ImportInsurance_Pom ImportInsurance = new ImportInsurance_Pom(driver);

            // Login
            loginpom.goToWebsite("https://insurance-manager.sb-qa-candidatetask.sisu.sh/login");
            loginpom.changeLanguage();
            loginpom.login("testsellingpartner1@simplesurance.de", "TestSellingPartner1Pass");

            // Click on the "Weiter zur Bezahlung" button
            ImportInsurance.clickImport();

            // Upload CSV file
            ImportInsurance.uploadCSV("C:\\Users\\Saad/Downloads/testdata.csv");
            //Create Insurance
            ImportInsurance.createInsuracne();

        } 
        
        catch (Exception e) 
        {
            throw new RuntimeException("Create a single Insurance Policy: " + e.getMessage(), e);
        } 
        
        finally 
        {
            // Close the browser session
            if (driver != null) 
           {
               driver.quit();
           }
        }
    }


    @Test(description = "Listing Functionality", priority = 3)
    public void Third() 
    {
        WebDriver driver = null;
        try {
            // Set up WebDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Create instance of LoginPage
            Login_Pom loginpom = new Login_Pom(driver);

            // Create instance of Filter and Sort
            FilterAndSort_Pom fandspom = new FilterAndSort_Pom(driver);

            // Login
            loginpom.goToWebsite("https://insurance-manager.sb-qa-candidatetask.sisu.sh/login");
            loginpom.changeLanguage();
            loginpom.login("testsellingpartner1@simplesurance.de", "TestSellingPartner1Pass");

            //Check Sort and Filter
            fandspom.checkSort();

        } 
        
        catch (Exception e) 
        {
            throw new RuntimeException("Create a single Insurance Policy: " + e.getMessage(), e);
        } 
        
        finally 
        {
            // Close the browser session
            if (driver != null) 
           {
               driver.quit();
           }
        }
    }
}