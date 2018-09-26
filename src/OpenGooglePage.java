package src;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.WebElement;
import java.util.*;


public class OpenGooglePage {

    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello World");
        // Telling the system where to find the Chrome driver
        System.setProperty(
                "webdriver.chrome.driver",
                "./chromedriver2");

        WebDriver webDriver = new ChromeDriver();

        // Open google.com
        webDriver.navigate().to("https://www.google.com");
        String html = webDriver.getPageSource();

        /* webDriver.navigate().to("https://prodmirror.company.com/");

        String html = webDriver.getPageSource();

        /*username = webDriver.find_element_by_name('USERNAME');
        username.send_keys('user1');

        password = webDriver.find_element_by_name('PASSWORD');
        password.send_keys('secret');
* /
        waitForLoad(webDriver);
        doLogin(webDriver);

        waitForLoad(webDriver);
        providerSelection(webDriver);

        waitForLoad(webDriver);
        selectDepartment(webDriver);


        waitForLoad(webDriver);
        closeInstruction(webDriver);

        waitForLoad(webDriver);
        createNewPatient(webDriver);
        */






        // Printing result here.
        System.out.println(html);

        Thread.sleep(10000);

        webDriver.close();
        webDriver.quit();
    }
    /*public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }*/

    public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public static void doLogin(WebDriver driver) {
        System.out.println("Start login");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("USERNAME")).clear();
        driver.findElement(By.id("USERNAME")).sendKeys("username");

        driver.findElement(By.id("PASSWORD")).clear();
        driver.findElement(By.id("PASSWORD")).sendKeys("password");

        driver.findElement(By.id("loginbutton")).click();
        System.out.println("End login");
    }

    public static void providerSelection(WebDriver driver) {
        System.out.println("Start providerSelection");
        driver.findElement(By.id("PRACTICEFINDTEXT")).sendKeys("90000");
        driver.findElement(By.id("loginbutton")).click();
        System.out.println("End providerSelection");
    }

    public static void selectDepartment(WebDriver driver) {
        System.out.println("Start selectDepartment");
        Select oSelect = new Select(driver.findElement(By.id("DEPARTMENTID")));

        oSelect.selectByVisibleText("Inpatient");

/*driver.selectByVisibleText("Text");
driver.selectByIndex(1);
driver.selectByValue("prog");*/

        driver.findElement(By.id("loginbutton")).click();
        System.out.println("End selectDepartment");
    }

    public static void closeInstruction(WebDriver driver) {
        /*driver.findElement(By.className("modalCloseImg")).click();

        WebElement element = driver.findElement(By.cssSelector("a[class='modalCloseImg']"));
        if(element != null)
            element.click();
        */
    }

    public static void createNewPatient(WebDriver driver) {

        /*
        if(driver.findElement(By.id("patientsmenucomponent")) != null) {
            driver.findElement(By.id("patientsmenucomponent")).click();
            System.out.println("patient id clicked");
        } else if(driver.findElement(By.name("Patients")) != null) {
            driver.findElement(By.name("Patients")).click();
            System.out.println("patient name clicked-1");
        }*/
        System.out.println("Start");

        /*WebElement addPolicyButton = driver.findElement(By.xpath("//div[@‌​id='patientsmenucomponent']"));

        JavascriptLibrary jsLib = new JavascriptLibrary();
        jsLib.callEmbeddedSelenium(driver,"triggerMouseEventAt", addPolicyButton,"click", "0,0");
        */


        /*categoryitem
        5580b62956c4ab5816392680e3426d95
*/
        //String elemHtml = driver.findElement(By.id(“someId”)).getAttribute(“innerHTML”);
        List<WebElement> checks =  driver.findElements(By.className("categoryitem"));

        for(int i = 0; i < checks.size(); ++i) {
            String elemHtml = checks.get(i).getAttribute("innerHTML");
            System.out.println(elemHtml);
        }
        // click the 3rd checkbox
        //checks.get(2).click();
    }




    public static void help(WebDriver driver){
        driver.findElement(By.xpath("//a[@href='target-URL']")).click();
    }



}

/*
cd /Users/srauta/Desktop/bkp/athena/test

javac -cp "./automation/selenium-java-3.11.0/client-combined-3.11.0-sources.jar:./automation/selenium-java-3.11.0/client-combined-3.11.0.jar:./automation/selenium-java-3.11.0/libs/*:$PATH:./automation/" automation/src/PatientCreate.java

java -cp "./automation/selenium-java-3.11.0/client-combined-3.11.0-sources.jar:./automation/selenium-java-3.11.0/client-combined-3.11.0.jar:./automation/selenium-java-3.11.0/libs/*:$PATH:./automation/" src.PatientCreate

*/
