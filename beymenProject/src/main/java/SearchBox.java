import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = By.xpath("//input[@placeholder='Ürün, Marka Arayın']");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text, Keys enter) throws InterruptedException {
        driver.findElement(searchBoxLocator).sendKeys("Pantolon",Keys.ENTER);
        Thread.sleep(2000);

    }
}