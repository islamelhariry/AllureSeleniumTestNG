package tests;

import io.qameta.allure.*;
import listeners.TestExecutionListener;
import org.testng.annotations.BeforeMethod;
import pages.AllListingsPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Web Application Regression Testing")
@Feature("All Listings Page Tests")
@Listeners(TestExecutionListener.class)
public class AllListingsTests extends BaseTest {

    AllListingsPage atAllListingPage;

    @BeforeMethod
    public void methodLevelSetup() {
        atAllListingPage = new AllListingsPage(driver);
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1, description = "Check All Listings Page")
    @Description("Test Description : Check that the 'All listings' page has the same number of listings as the 'All' label")
    @Story("Successful displaying of all listings")
    public void AllListingsTest() {
        atAllListingPage
            .Given()
                .InitialListingsAreDisplayed()
            .When()
                .PageIsScrolledTillEndOfListings()
            .Then()
                .ListingsCounterMatchesAllDisplayedListingsNumber();
      }
}
