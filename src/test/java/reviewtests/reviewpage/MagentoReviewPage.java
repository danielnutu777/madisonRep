package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://qa3.madison.com/")
public class MagentoReviewPage extends PageObject {
    @FindBy(css = "#reviwGrid_table > tbody > tr:nth-child(1) > td:nth-child(3)")
    private WebElement editProductBtn;
    @FindBy(id = "product_info_tabs_reviews")
    private WebElement selectReviewTab;
    @FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody/tr[1]/td[3]")
    private WebElement latestProductReview;
    @FindBy(xpath = "//*[@id=\"status_id\"]")
    private WebElement changeStatus;
    @FindBy(xpath = "//*[@id=\"save_button\"]/span/span/span")
    private WebElement save;
    @FindBy(css = "#nav > li:nth-child(3)")
    private WebElement catalogBtn;
    @FindBy(css = "#nav > li:nth-child(3) > ul > li:nth-child(6) > ul > li.parent.level2 > a > span")
    private WebElement reviewsBtn;
    @FindBy(css = "#nav > li:nth-child(3) > ul > li:nth-child(6) > a > span")
    private WebElement reviewsAndRatingsBtn;
    @FindBy(css = "#nav > li:nth-child(3) > ul > li:nth-child(6) > ul > li.parent.level2 > ul > li:nth-child(1) > a > span")
    private WebElement pendingReviewsBtn;
    @FindBy(xpath = "//*[@id=\"nav\"]/li[3]/ul/li[6]/ul/li[1]/ul/li[2]/a/span")
    private WebElement allReviewsBtn;
    @FindBy(css = "#customer-reviews > dl > dt:nth-child(1) > a")
    private WebElement assertReview;

    public void getMagentoReviewPage() {
        getDriver().get("http://qa3.madison.com/index.php/admin/index/index/key/e648485994b064ccc6db26c47feeed0a/");
    }
    public void enterReviewSection() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(catalogBtn).build().perform();
        builder.moveToElement(reviewsAndRatingsBtn).build().perform();
        builder.moveToElement(reviewsBtn).build().perform();
        builder.moveToElement(pendingReviewsBtn).build().perform();
        builder.moveToElement(allReviewsBtn).build().perform();
        clickOn(allReviewsBtn);
    }
    public void deleteReview() {
        waitABit(3000);
        clickOn(editProductBtn);
        selectFromDropdown(changeStatus, "Not Approved");
        clickOn(save);
    }
    public void assertReviewMsgIsDeleted(String d) {
        getDriver().get(d);
        String s = assertReview.getText();
        Assert.assertNotEquals(s, "TEST");
        System.out.println("Review successfully removed.");
    }
}

