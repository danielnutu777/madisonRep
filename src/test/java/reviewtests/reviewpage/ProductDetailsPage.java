package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("http://qa3.madison.com/")
public class ProductDetailsPage extends PageObject {

    @FindBy(css = ".toggle-tabs li:nth-child(3)")
    WebElement reviewsLink;
    @FindBy(css = "a[href$=\"#review-form\"]")
    WebElement reviewBtn;
    @FindBy(css = "a[href$=\"#review-form\"]")
    WebElement reviewBtn2;
    @FindBy(className = "h1")
     WebElement productName;

    public void clickOnReviews() {
        clickOn(reviewsLink);
        try {
            clickOn(reviewBtn);
        } catch (Exception e) {
            clickOn(reviewBtn2);
        }
    }
    public String getProductName(){
        return productName.getText();
    }
}