/* @Author: Dmytro.Tyrtyshnyi@gmail.com */
package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static util.Constants.*;

@Log4j2
public class ComputersPage extends AbstractPage {
    public ComputersPage() { super(); }

    @FindBy(xpath = "//div[@class ='page category-page']")
    private WebElement categoryPageBanner;

    public ComputersPage openComputersPage() {
        computersTitle.click();
        wait.until(ExpectedConditions.elementToBeClickable(categoryPageBanner));
        waitUntilPageIsFullyLoaded(wait);
        perfNavigationTiming.writeToInflux("ComputersPage");
        log.info("Computers page is loaded");
        return this;
    }
}
