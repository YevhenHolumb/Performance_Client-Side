/* @Author: Dmytro.Tyrtyshnyi@gmail.com */
package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

@Log4j2
public class DesktopsPage extends AbstractPage{
    public DesktopsPage() { super(); }

    @FindBy(xpath = "//div/a[@href='/desktops']")
    private WebElement desktopsPageButton;

    @FindBy(xpath = "//div[@class='item-box']//a")
    private List<WebElement> desktopsProductsList;

    @FindBy(xpath = "//div[@class='product-name']//h1")
    private WebElement openedDesktopTitle;

    @FindBy(xpath = "//div[@class='add-to-cart-panel']//button")
    private WebElement addToCartButton;


    public DesktopsPage openDesktopsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(desktopsPageButton));
        desktopsPageButton.click();
        log.info("Clicked on 'DesktopPageButton'");
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("DesktopPage");
        log.info("Desktops list is appeared");
        return this;
    }

    public DesktopsPage openAnyDesktop() {
        int randomItem = new Random().nextInt(desktopsProductsList.size());
        String firstLaptopInTheListName = desktopsProductsList.get(randomItem).getText();
        log.info("Let's grab any desktop: " + firstLaptopInTheListName);
        desktopsProductsList.get(randomItem).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        Assert.assertTrue(openedDesktopTitle.getText().contains(firstLaptopInTheListName), "Wrong desktop was opened");
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("ProductPage");
        log.info("Asserted that the desktop we wanted to open and actually opened desktop are the same product");
        return this;
    }

}
