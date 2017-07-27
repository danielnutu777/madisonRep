package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://qa3.madison.com/")
public class ProductDetailsPage extends PageObject {

    @FindBy(css = ".toggle-tabs li:nth-child(3)")
    private WebElement reviewsLink;
    @FindBy(css = "a[href$=\"#review-form\"]")
    private WebElement reviewBtn;
    @FindBy(css = "a[href$=\"#review-form\"]")
    private WebElement reviewBtn2;
    @FindBy(className = "h1")
    private WebElement productName;
    @FindBy(css = "#customer-reviews > dl > dt:nth-child(1) > a")
    private WebElement assertReview;

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
    public void assertReviewMsg(String d) {
        getDriver().get(d);
        String s = assertReview.getText();
        Assert.assertEquals(s, "TEST");
        System.out.println("Review successfully added.");
    }
    public String getLink(){
        return getDriver().getCurrentUrl();
    }
}