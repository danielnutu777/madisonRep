package emag.maven.project.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Random;

@DefaultUrl("https://www.emag.ro/")
public class RandomProductListingPage extends PageObject {
    @FindBy(className = "gtm_search_bar_click_search_week")
    WebElement searchBar;

    @FindBy(className = "icon-i10-search")
    WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"emg-pagination-numbers\"]/a[5]")
    List<WebElement> maxPages;

    @FindBy(css = ".lazy")
    List<WebElement> products;

    @FindBy(css = ".page-title")
    WebElement title;

    @FindBy(css = ".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.gtm_680klw")
    WebElement addBtn;

    @FindBy(css = ".line-item-title.main-product-title")
    WebElement productTitle;

    @FindBy(css = ".modal-content .btn-primary")
    WebElement detailsBtn;


    public void searchProducts(String product) {
        typeInto(searchBar, product);
        waitABit(2000);
        clickOn(searchBtn);
    }

    Random rand = new Random();

    public void getRandomPage() {
        String searchedProduct = "iphone+7";
        int noOfPages;
        noOfPages = Integer.parseInt(maxPages.get(maxPages.size() - 1).getText());
        System.out.println(noOfPages);
        int pageNumber = rand.nextInt(noOfPages) + 1;
        System.out.println(pageNumber);
        getDriver().navigate().to("https://emag.ro/search/" + searchedProduct + "/p" + pageNumber);
        waitABit(2000);
    }

    public void getRandomProduct() {
        int product = rand.nextInt(products.size()) - 1;
        System.out.println(product);
        products.get(product).click();
    }

    public void addToCart() {
        String productName = title.getText();
        clickOn(addBtn);
        clickOn(detailsBtn);
        String productNameInCart = productTitle.getText();
        Assert.assertEquals(productName, productNameInCart);
    }
}
