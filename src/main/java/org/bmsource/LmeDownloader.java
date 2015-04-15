package org.bmsource;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LmeDownloader
{
    private static Logger log = Logger.getLogger(LmeDownloader.class);

    public static void run() throws IOException
    {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.metalsmarket.net/login.php");
        WebElement login = driver.findElement(By.name("username"));
        login.sendKeys("vamax");
        WebElement passwd = driver.findElement(By.name("password"));
        passwd.sendKeys("2371");
        WebElement submit = driver.findElement(By.name("login"));
        submit.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String base = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        System.err.println("opened windows " + set);
        set.remove(base);
        driver.switchTo().window((String) set.toArray()[0]);
        driver.close();
        driver.switchTo().window(base);

        try
        {
            while (true)
            {
                String fileName = "001";
                WebElement menuItem1 = driver.findElement(By.id("menuItem1"));
                menuItem1.click();
                createScreenshot(driver, fileName);

                WebElement menuItem23 = driver.findElement(By.id("menuItem23"));
                menuItem23.click();
                fileName = "002";
                createScreenshot(driver, fileName);

                WebElement menuItem2 = driver.findElement(By.id("menuItem2"));
                menuItem2.click();
                fileName = "003";
                createScreenshot(driver, fileName);

                WebElement menuItem28 = driver.findElement(By.id("menuItem28"));
                menuItem28.click();
                fileName = "004";
                createScreenshot(driver, fileName);

                WebElement menuItem6 = driver.findElement(By.id("menuItem6"));
                menuItem6.click();
                fileName = "005";
                createScreenshot(driver, fileName);

                WebElement menuItem7 = driver.findElement(By.id("menuItem7"));
                menuItem7.click();
                fileName = "006";
                createScreenshot(driver, fileName);

                WebElement menuItem8 = driver.findElement(By.id("menuItem8"));
                menuItem8.click();
                fileName = "007";
                createScreenshot(driver, fileName);

                WebElement menuItem9 = driver.findElement(By.id("menuItem9"));
                menuItem9.click();
                fileName = "008";
                createScreenshot(driver, fileName);

                WebElement menuItem10 = driver.findElement(By.id("menuItem10"));
                menuItem10.click();
                fileName = "009";
                createScreenshot(driver, fileName);

                WebElement menuItem11 = driver.findElement(By.id("menuItem11"));
                menuItem11.click();
                fileName = "010";
                createScreenshot(driver, fileName);

                WebElement menuItem12 = driver.findElement(By.id("menuItem12"));
                menuItem12.click();
                fileName = "011";
                createScreenshot(driver, fileName);

                WebElement menuItem13 = driver.findElement(By.id("menuItem13"));
                menuItem13.click();
                fileName = "012";
                createScreenshot(driver, fileName);

                WebElement menuItem14 = driver.findElement(By.id("menuItem14"));
                menuItem14.click();
                fileName = "013";
                createScreenshot(driver, fileName);

                WebElement menuItem4 = driver.findElement(By.id("menuItem4"));
                menuItem4.click();
                fileName = "014";
                createScreenshot(driver, fileName);

                log.info("images refreshed at " + new Date());

                //driver.quit();     
                Thread.sleep(10000);
            }
        } catch (Exception e)
        {
            log.error("Exception throws ", e);
            e.printStackTrace();
        }
    }

    private static void createScreenshot(WebDriver driver, String fileName) throws IOException
    {
        String path = "f:/workspace/scrap/public/lme/";
        if (!System.getProperty("os.name").startsWith("Windows"))
            path = "/home/scrap/public/lme/";

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(path + fileName + ".png"));
    }
}
