import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

/*
Browser class opens and accesses the three URLs and enters information to 
the first URl's login page and then traverses to the "home page," which
is the second URL for personal access. Libraries mainly used include Selenium
WebDriver and SafariDriver, Actions, By, and TimeUnit. 
*/

public class Browser {
    public static void main(String[] args) {

        String url1 = "https://icon.uiowa.edu";
        String url2 = "https://www.office.com/";
        String url3 = "https://scitechdaily.com";
            
            try {

                WebDriver driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.get(url1);

                String main_tab = driver.getWindowHandle();
                
                ArrayList<String> tabs = new ArrayList<String>();
                tabs.add(url2);
                tabs.add(url3);

                // JavaScript driver is used to effectively open necessary tabs
                JavascriptExecutor js = (JavascriptExecutor) driver;
                
                for (String tab : tabs) {
                    js.executeScript("window.open();");

                    // The open ArrayList is initialized with each URL's handles in order to 
                    // pass through and open each URL in order
                    ArrayList<String> open = new ArrayList<>(driver.getWindowHandles());
                    open.remove(main_tab);

                    for (String opened : open) {
                        String current_url = driver.getCurrentUrl();
                        if (!main_tab.equalsIgnoreCase(opened) && !opened.equals(current_url)) {
                            TimeUnit.SECONDS.sleep(2);
                            driver.switchTo().window(opened);
                            TimeUnit.SECONDS.sleep(2);
                            driver.get(tab);
                            TimeUnit.SECONDS.sleep(2);
                            open.remove(opened);
                            break;
                        }
                    }
                }

                driver.switchTo().window(main_tab);
                WebDriverWait wait = new WebDriverWait(driver, 20);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hawkid"))).sendKeys("cmaskel");
                
                // Actions is used to perform the TAB operation to get to the second URL, or "home page"
                Actions action= new Actions(driver);
                action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
            }

            // Catches an error for the TimeUnit.SECONDS.sleep() actions
            catch (InterruptedException e) {
                e.printStackTrace();
         }
     } 
 }
    
