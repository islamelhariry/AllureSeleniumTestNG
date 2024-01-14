package tests;
import io.qameta.allure.*;
import listeners.TestExecutionListener;
import org.testng.annotations.BeforeMethod;
import pages.SearchPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Web Application Regression Testing")
@Feature("Filter Form Tests")
@Listeners(TestExecutionListener.class)
public class SearchTests extends BaseTest {

    SearchPage atSearchPage;

    @BeforeMethod
    public void methodLevelSetup() {
        atSearchPage = new SearchPage(driver);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "Check all properties in the filter form")
    @Description("Test Description : Check filters form: entry fields, checkboxes, minimum and maximum values, amenities checkboxes, “Clear all” is functional")
    @Story("Successful functionality of filter form")
    public void SearchListings() {

        atSearchPage
            .Given()
                .FiltersFormIsDisplayed()
            .And()
                .FiltersAreVisible()
            .When()
                .AllFiltersAreSelected()
            .And()
                .ClearAllIsClicked()
            .Then()
                .AllFiltersAreCleared();
    }
}
