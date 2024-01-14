package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage extends BasePage<SearchPage>{


    By searchButton = By.xpath("//div[@class='sc-jVSGNQ hzsGOz']");
    By filterButton = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[5]/button");
    By checkInDate = By.xpath("//*[@idsc-giAqHp iIKBzI=\"app\"]/div/div[1]/div/div[2]/div/div/div[2]/div[2]");
    By checkOutDate = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[3]/div/div/div[2]/div[2]");
    By fromTextBox = By.xpath("//input[@placeholder='From']");
    By toTextBox = By.xpath("//input[@placeholder='To']");

    By filtersTitle = By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div");
    By priceHeadline = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]");
    By roomsAndBedsHeadline = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]");
    By amenitiesHeadline = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]");

    By bedsLabel = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]");
    By bedsPlusButton = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]/div[2]/div/button[2]");
    By bedroomsLabel = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]/div[1]");
    By bedroomsPlusButton = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]/div[2]/div/button[2]");
    By bathroomsLabel = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]");
    By bathroomsPlusButton = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]/div[2]/div/button[2]");
    By petsAllowedCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[1]/label/span");
    By airConditioningCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[2]/label/span");
    By beachFrontCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[3]/label/span");
    By freeWiFiCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[4]/label/span");
    By swimmingPoolCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[5]/label/span");
    By kitchenCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[6]/label/span");
    By washingMachineCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[7]/label/span");
    By hotTubCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[8]/label/span");
    By streetParkingCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[9]/label/span");
    By suitableForChildernCheckBox = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]/div[10]/label/span");

    By clearAllButton = By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/b");
    By applyButton = By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/button");

    public SearchPage(WebDriver driver) {
        super(driver, "https://kamil-demo.alpinizm.uz/");
    }
    @Step("Click on search button")
    public SearchPage clickSearch() {
        driver.findElement(searchButton).click();

        return this;
    }
    @Step("Click on filter button")
    public SearchPage clickFilter() {
        driver.findElement(filterButton).click();

        return this;
    }
    @Step("Go to filter form")
    public SearchPage FiltersFormIsDisplayed() {
        this.clickSearch();
        this.clickFilter();

        return this;
    }
    @Step("Check all labels & filters")
    public SearchPage FiltersAreVisible() {
        FilterTitleIsVisible();
        PriceTitleAndFiltersAreVisible();
        RoomsAndBedsTitleAndFiltersAreVisible();
        AmenitiesTitleAndFiltersAreVisible();

        return this;
    }

    @Step("Check filters title")
    public SearchPage FilterTitleIsVisible() {
        Assert.assertEquals(driver.findElement(filtersTitle).getText(), "Filters");

        return this;
    }

    @Step("Check price title & filters")
    public SearchPage PriceTitleAndFiltersAreVisible() {
        Assert.assertEquals(driver.findElement(priceHeadline).getText(), "Price");
        Assert.assertTrue(driver.findElement(fromTextBox).isDisplayed());
        Assert.assertTrue(driver.findElement(toTextBox).isDisplayed());

        return this;
    }

    @Step("Check rooms and beds title & filters")
    public SearchPage RoomsAndBedsTitleAndFiltersAreVisible() {
        Assert.assertEquals(driver.findElement(roomsAndBedsHeadline).getText(), "Rooms and beds");
        Assert.assertTrue(driver.findElement(bedsLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(bedsPlusButton).isDisplayed());
        Assert.assertTrue(driver.findElement(bedroomsLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(bedroomsPlusButton).isDisplayed());
        Assert.assertTrue(driver.findElement(bathroomsLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(bathroomsPlusButton).isDisplayed());

        return this;
    }

    @Step("Check amenities title & filters")
    public SearchPage AmenitiesTitleAndFiltersAreVisible() {
        Assert.assertEquals(driver.findElement(amenitiesHeadline).getText(), "Amenities");
        Assert.assertTrue(driver.findElement(petsAllowedCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(airConditioningCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(beachFrontCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(freeWiFiCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(swimmingPoolCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(kitchenCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(washingMachineCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(hotTubCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(streetParkingCheckBox).isDisplayed());
        Assert.assertTrue(driver.findElement(suitableForChildernCheckBox).isDisplayed());

        return this;
    }

    @Step("Select rooms and beds filters")
    public SearchPage BedroomFiltersAreSelected() {
        driver.findElement(bedsPlusButton).click();
        driver.findElement(bedroomsPlusButton).click();
        driver.findElement(bathroomsPlusButton).click();

        return this;
    }

    @Step("Select amenities filters")
    public SearchPage AmenitiesFiltersAreSelected() {
        driver.findElement(bedsPlusButton).click();
        driver.findElement(bedroomsPlusButton).click();
        driver.findElement(bathroomsPlusButton).click();
        driver.findElement(petsAllowedCheckBox).click();
        driver.findElement(airConditioningCheckBox).click();
        driver.findElement(beachFrontCheckBox).click();
        driver.findElement(freeWiFiCheckBox).click();
        driver.findElement(swimmingPoolCheckBox).click();
        driver.findElement(kitchenCheckBox).click();
        driver.findElement(washingMachineCheckBox).click();
        driver.findElement(hotTubCheckBox).click();
        driver.findElement(streetParkingCheckBox).click();
        driver.findElement(suitableForChildernCheckBox).click();

        return this;
    }

    @Step("Select all filters")
    public SearchPage AllFiltersAreSelected() {
        BedroomFiltersAreSelected();
        AmenitiesFiltersAreSelected();

        return this;
    }

    @Step("Click on clear all button")
    public SearchPage ClearAllIsClicked() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(clearAllButton).click();

        return this;
    }

    @Step("Check that rooms and beds filters are cleared")
    public SearchPage BedroomFiltersAreCleared() {
        Assert.assertFalse(driver.findElement(bedsPlusButton).isSelected());
        Assert.assertFalse(driver.findElement(bedroomsPlusButton).isSelected());
        Assert.assertFalse(driver.findElement(bathroomsPlusButton).isSelected());

        return this;
    }

    @Step("Check that amenities filters are cleared")
    public SearchPage AmenitiesFiltersAreCleared()
    {
        Assert.assertFalse(driver.findElement(petsAllowedCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(airConditioningCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(beachFrontCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(freeWiFiCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(swimmingPoolCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(kitchenCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(washingMachineCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(hotTubCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(streetParkingCheckBox).isSelected());
        Assert.assertFalse(driver.findElement(suitableForChildernCheckBox).isSelected());

        return this;
    }

    @Step("Check that all filters are cleared")
    public SearchPage AllFiltersAreCleared() {
        BedroomFiltersAreCleared();
        AmenitiesFiltersAreCleared();

        return this;
    }
}