package e2e.navigation.navi2;

import pageObjects.voting.MonitorPage;
import actions.interfaces.WelcomeActions;
import base.SeleniumBaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**use interfaces instead of pageObjects*/
public class Navigation2 extends SeleniumBaseTest {

    WelcomeActions welcomeActions = new WelcomeActions();
    MonitorPage monitorPage = new MonitorPage();

    @Test
    public void navigateToMonitorPage(){
        welcomeActions.navigateTo();
        welcomeActions.pressMonitorElectionProcess();

        assertTrue(monitorPage.isOnPage());
    }
}
