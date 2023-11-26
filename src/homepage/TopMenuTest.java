package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        WebElement desktop = driver.findElement(By.linkText("Desktops"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktop).click().build().perform();
        selectMenu("Show All Desktops");
        String expected = "Desktops";
        String actual = getTextFromElement(By.xpath("//li[contains(.,'Desktops')]"));
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        WebElement ln = driver.findElement(By.linkText("Laptops & Notebooks"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ln).click().build().perform();
        selectMenu("Show All Laptops & Notebooks");
        String expected = "Laptops & Notebooks";
        String actual = getTextFromElement(By.xpath("//a[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        WebElement components = driver.findElement(By.linkText("Components"));
        Actions actions = new Actions(driver);
        actions.moveToElement(components).click().build().perform();
        selectMenu("Show AllComponents");
        String expected = "Components";
        String actual = getTextFromElement(By.xpath("//a[starts-with(text(),'Components')]"));
        Assert.assertEquals(expected, actual);
    }

}
