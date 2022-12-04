import org.testng.annotations.Test;

import static util.Constants.*;

public class Test_ClientSidePA extends SetUpScenario{

    @Test (priority = 1)
    public void openMainPage() {
        MAIN_PAGE.openMainPage();
    }

    @Test (priority = 2)
    public void openComputersPage() {
        COMPUTERS_PAGE.openComputersPage();
    }

    @Test (priority = 3)
    public void openDesktopsPage() {
        DESKTOPS_PAGE.openDesktopsPage();
    }

    @Test (priority = 4)
    public void openAnyOfDesktopsPage() {
        DESKTOPS_PAGE.openAnyDesktop();
    }
}
