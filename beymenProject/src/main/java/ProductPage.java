import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage extends BasePage{

    By filterOptionsLocator = By.xpath("//input[@placeholder='Ürün, Marka Arayın']");
    By selectProductLocator = By.cssSelector("div#productList>:nth-of-type(3)");
    By moreContentButtonLocator=By.cssSelector("button#moreContentButton");
    By productPagePrice = By.cssSelector("m-productCard__newPrice");



    public ProductPage(WebDriver driver) {
        super(driver);
    }



    public void selectAProduct() throws InterruptedException {
        click(selectProductLocator);
        Thread.sleep(2000);


    }

    public boolean isOnProductPage() {
        return isDisplayed(filterOptionsLocator);

    }

    public void scrollAndClickMore() throws InterruptedException {
        Thread.sleep(1500);
        scroll();
        click(moreContentButtonLocator);

    }


}