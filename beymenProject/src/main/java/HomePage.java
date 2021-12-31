import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage extends BasePage{
    SearchBox searchBox;

    By goToCartLocator = By.xpath("//a[@href='/cart']");
    By myAccLocator = By.xpath("/html/body/header/div/div/div[3]/div/a[1]/span");
    By favLocator = By.xpath("/html/body/header/div/div/div[3]/div/a[2]/span");
    By basketLocator = By.xpath("/html/body/header/div/div/div[3]/div/a[3]/span");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public boolean isOnHomePageAcc() throws InterruptedException {
        Thread.sleep(2000);
        return isDisplayed(myAccLocator);
    }
    public boolean isOnHomePageFav() throws InterruptedException {
        Thread.sleep(2000);
        return isDisplayed(favLocator);
    }
    public boolean isOnHomePageBasket() throws InterruptedException {
        Thread.sleep(2000);
        return isDisplayed(basketLocator);
    }
    public SearchBox searchBox() {
        return this.searchBox;
    }



    public void goToCart() throws InterruptedException {
        click(goToCartLocator);
        Thread.sleep(2000);

    }






}