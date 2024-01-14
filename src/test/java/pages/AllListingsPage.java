package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AllListingsPage extends BasePage<AllListingsPage>{

    By allListingsCounter = By.xpath("//span[@class='sc-bsatvv hYJCa']");
    By allListingsGrid = By.xpath("//div[@class='sc-iNiQyp gsJhBT']");
    By listingLocator = By.xpath("//div[@class='sc-fnebDD bAGyCr']");

    public AllListingsPage(WebDriver driver) {
        super(driver, "https://kamil-demo.alpinizm.uz/all-listings");
    }

    @Step("Check that some listing are displayed")
    public AllListingsPage InitialListingsAreDisplayed() {
        driver.findElement(allListingsGrid).isDisplayed();

        return this;
    }

    @Step("Scroll down to the end of the listings in the page")
    public AllListingsPage PageIsScrolledTillEndOfListings() {
        int allListingsCount = getAllListingCounter();
        int currentListingsCount = 0;

        do {
            scrollDownToPageEnd();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listingLocator, currentListingsCount));
            currentListingsCount = driver.findElements(listingLocator).size();
        } while (currentListingsCount < allListingsCount);

        return this;
    }

    @Step("Check that all listings counter matches the number of all listings displayed")
    public AllListingsPage ListingsCounterMatchesAllDisplayedListingsNumber() {
        int counter = getAllListingCounter();
        List<WebElement> listings = getAllListingsList();
        Assert.assertEquals(listings.size(), counter);

        return this;
    }

    private int getAllListingCounter()  {
        wait.until(ExpectedConditions.attributeContains(allListingsCounter, "innerText", "("));
        String allListingContent = driver.findElement(allListingsCounter).getText();
        return Integer.parseInt(allListingContent.substring(5,allListingContent.length()-1));
    }

    private List<WebElement> getAllListingsList() {
        return driver.findElements(listingLocator);
    }

    private void scrollDownToPageEnd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
