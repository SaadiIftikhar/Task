import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddInsurance_Pom {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddInsurance_Pom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void addInsurance() {
        clickAddNew();
        selectCountry();
        selectProductName();
        selectTariff();
        selectInsuranceCategory();
        selectPeriod();
        selectPaymentType();
        selectClass();
        addSerialNumber();
        addDeviceName();
        addInvoiceNumber();
        addOrderNumber();
        clickNext();
        selectMister();
        addCustomerDetails();
        clickNext();
        confirmProcess();
        clickCheckboxes();
        clickCreateInsurance();
        goToPayment();
        addCreditCardDetails();
        processCreditCard();
        confirmPayment();
        goToList();
        verifyEmail();
    }
    String randomizedEmail = generateRandomEmail();

    private void clickAddNew() {
        WebElement addNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > a:nth-child(2) > button:nth-child(1)")));
        addNew.click();
    }

    private void selectCountry() {
        driver.findElement(By.cssSelector("#country-select")).click();
        WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-child(5)")));
        country.click();
    }

    private void selectProductName() {
        driver.findElement(By.cssSelector("#product-name-select")).click();
        WebElement pname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[role='option']")));
        pname.click();
    }

    private void selectTariff() {
        driver.findElement(By.cssSelector("#tariff-name-select")).click();
        WebElement tariff = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[role='option']")));
        tariff.click();
    }

    private void selectInsuranceCategory() {
        driver.findElement(By.cssSelector("#category-name-select")).click();
        WebElement insuranceCat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[role='option']")));
        insuranceCat.click();
    }

    private void selectPeriod() {
        driver.findElement(By.cssSelector("#duration-select")).click();
        WebElement period = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='12 month(s)']")));
        period.click();
    }

    private void selectPaymentType() {
        driver.findElement(By.cssSelector("#frequency-select")).click();
        WebElement pType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(4) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)")));
        pType.click();
    }

    private void selectClass() {
        driver.findElement(By.cssSelector("#class-name-select")).click();
        WebElement sClass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space()='Nokia 3/500 - EUR 500.00']")));
        sClass.click();
    }

    private void addSerialNumber() {
        driver.findElement(By.id("input-createCertificate_serialNumber")).sendKeys("12345");
    }

    private void addDeviceName() {
        driver.findElement(By.id("input-createCertificate_deviceName")).sendKeys("Nokia");
    }

    private void addInvoiceNumber() {
        driver.findElement(By.id("input-createCertificate_invoiceNumber")).sendKeys("12345");
    }

    private void addOrderNumber() {
        driver.findElement(By.id("input-createCertificate_orderNumber")).sendKeys("12345");
    }

    private void clickNext() {
        WebElement next = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Next')]")));
        next.click();
    }

    private void selectMister() {
        WebElement mr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Mr.')]")));
        mr.click();
    }

    private void addCustomerDetails() {
        driver.findElement(By.id("input-createCertificate_firstName")).sendKeys("Saad");
        driver.findElement(By.id("input-createCertificate_lastName")).sendKeys("Iftikhar");
        driver.findElement(By.id("input-createCertificate_email")).sendKeys(randomizedEmail);
        driver.findElement(By.id("input-createCertificate_streetName")).sendKeys("Straße der Jugend");
        driver.findElement(By.id("input-createCertificate_streetNumber")).sendKeys("15");
        driver.findElement(By.id("input-createCertificate_zip")).sendKeys("03046");
        driver.findElement(By.id("input-createCertificate_city")).sendKeys("Cottbus");
        driver.findElement(By.id("input-createCertificate_country")).sendKeys("DE");
        driver.findElement(By.id("input-createCertificate_taxCode")).sendKeys("12345");
    }

    private void confirmProcess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'All information is correct.')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'The customer consents that his personal data will be transmitted to and processed by simplesurance GmbH for the fulfilment of the insurance contract.')]")));
    }

    private void clickCheckboxes() {
        for (int i = 1; i <= 4; i++) {
            driver.findElement(By.xpath("(//input[@type='checkbox'])[" + i + "]")).click();
        }
    }

    private void clickCreateInsurance() {
        WebElement cInsurance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Create insurance')]")));
        cInsurance.click();
    }

    private void goToPayment() {
        WebElement importcsv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Weiter zur Bezahlung')]")));
        importcsv.click();
    }

    private void addCreditCardDetails() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe")));
        driver.switchTo().frame(iframe);
        WebElement cardNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Kartennummer']")));
        cardNumber.click();
        cardNumber.sendKeys("42424242424242420430633");
        driver.switchTo().defaultContent();
    }

    private void processCreditCard() {
        WebElement pNext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(., 'Kostenpflichtig bestellen')]")));
        pNext.click();
    }

    private void confirmPayment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Coverages')]")));
    }

    private void goToList() {
        WebElement gotoList = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(., 'List')]")));
        gotoList.click();
    }

    private void verifyEmail() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(., '"+randomizedEmail+"')]")));
    }

    // Method to generate a random email address
    private String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder email = new StringBuilder();
        Random rand = new Random();

        // Append random characters to the email prefix
        for (int i = 0; i < 8; i++) {
            email.append(allowedChars.charAt(rand.nextInt(allowedChars.length())));
        }

        // Append a random number to ensure uniqueness
        email.append(rand.nextInt(1000));

        // Append the domain name
        email.append("@mailinator.com");

        return email.toString();
    }
}
