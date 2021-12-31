import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    By addToCartButtonLocator = By.cssSelector("button#addBasket");
    By selectSizeButtonLocator1 = By.cssSelector("span.m-variation__item");
    By selectSizeButtonLocator2 = By.cssSelector("span.m-variation__item -criticalStock");
    By productDetailPagePrice = By.id("priceNew");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void selectSize() throws InterruptedException {

        try {
            click(selectSizeButtonLocator1);
        }catch (Exception e){
            click(selectSizeButtonLocator2);
        }
        Thread.sleep(1500);


    }

    public void addToCart() throws InterruptedException {
        click(addToCartButtonLocator);

        Thread.sleep(2500);
    }


    public String getDetailPagePrice() throws InterruptedException {
        Thread.sleep(2000);
        return getText(productDetailPagePrice);
    }


}