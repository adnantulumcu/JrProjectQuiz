import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class CartPage extends BasePage {
    ProductPage productPage;

    By selectQuantityButtonLocator = By.cssSelector("select#quantitySelect0>:nth-of-type(2)");
    By removeCartButtonLocator = By.cssSelector("button#removeCartItemBtn0");
    By emptyCartPageLocator = By.cssSelector("strong.m-empty__messageTitle");
    By correctQuantityLocator = By.xpath("//option[@value='2']");







    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void selectQuantity() throws InterruptedException {
        click(selectQuantityButtonLocator);
        Thread.sleep(1500);
    }
    public boolean checkIfProductQuantity() {
        return isDisplayed(correctQuantityLocator) ;
    }




    public void removeProduct() throws InterruptedException {
        click(removeCartButtonLocator);
        Thread.sleep(2000);
    }


    public boolean emptyCartBasket() {
        return isDisplayed(emptyCartPageLocator);
    }








}