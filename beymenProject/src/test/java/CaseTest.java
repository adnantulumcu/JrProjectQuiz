import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class CaseTest extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;



    @Test
    @Order(1)
    public void IsOnHomePage() throws InterruptedException {
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        Assertions.assertTrue(homePage.isOnHomePageAcc(),"Not on home page!");
        logger.info("Hesabım bulunuyor mu kontrol ediliyor.");
        Assertions.assertTrue(homePage.isOnHomePageFav(),"Not on home page!");
        logger.info("Favoriler bulunuyor mu kontrol ediliyor.");
        Assertions.assertTrue(homePage.isOnHomePageBasket(),"Not on home page!");
        logger.info("Sepetim bulunuyor mu kontrol ediliyor.");
        homePage.searchBox().search("Pantolon", Keys.ENTER);
        logger.info("Pantolon aranıyor");
        Assertions.assertTrue(productPage.isOnProductPage(),"Not on product page!");

    }


    @Test
    @Order(2)
    public void selectAProduct() throws InterruptedException {
        productDetailPage = new ProductDetailPage(driver);
        productPage.scrollAndClickMore();
        logger.info("Sayfanın sonuna iniliyor ve daha fazlasını görüntüleye tıklanıyor");
        productPage.selectAProduct();
        logger.info("Bir ürün seçiliyor");
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"Not on product detail page!");
    }
    @Test
    @Order(3)
    public void addProductToCart() throws InterruptedException {
        productDetailPage.selectSize();
        logger.info("Ürün beden seçiliyor");
        productDetailPage.addToCart();
        logger.info("Ürün sepete ekleniyor");
    }


    @Test
    @Order(4)
    public void quantityOfProduct() throws InterruptedException {
        cartPage = new CartPage(driver);
        homePage.goToCart();
        logger.info("Sepete gidiliyor");
        cartPage.selectQuantity();
        logger.info("Ürün sayısı artırılıyor");
        Assertions.assertTrue(cartPage.checkIfProductQuantity(),"Product quantity was not correct!");
    }



    @Test
    @Order(5)
    public void emptyCart() throws InterruptedException {
        cartPage.removeProduct();
        logger.info("Ürün sepetten siliniyor");
        Assertions.assertTrue(cartPage.emptyCartBasket(),"Basket is not empty!");
        logger.info("Sepetin boş olduğu kontrol ediliyor");
    }

}