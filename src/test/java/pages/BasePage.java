package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage<T extends BasePage<T>> {
    public WebDriver driver;
    public WebDriverWait wait;
    String baseURL;

    public BasePage(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        this.driver.get(baseURL);
    }
       public T Given()
    {
        return (T) this;
    }

    public T When()
    {
        return (T) this;
    }
    public T And()
    {
        return (T) this;
    }
    public T Then()
    {
        return (T) this;
    }
}
