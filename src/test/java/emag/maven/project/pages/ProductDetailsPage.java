package emag.maven.project.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.emag.ro/")
public class ProductDetailsPage extends PageObject{
    @FindBy(css = ".page-title")
    private WebElement title;
    @FindBy(css = ".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.gtm_680klw")
    private WebElement addBtn;
    @FindBy(css = ".line-item-title.main-product-title")
    private WebElement productTitle;
    @FindBy(css = ".modal-content .btn-primary")
    private WebElement detailsBtn;

    public void addToCart() {
        String productName = title.getText();
        clickOn(addBtn);
        clickOn(detailsBtn);
        String productNameInCart = productTitle.getText();
        Assert.assertEquals(productName, productNameInCart);
    }
}
