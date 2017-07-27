package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://qa3.madison.com/index.php/admin/index/index/key/b9ed11cbb3674abe7a30dff5ab0cf2ac/")
public class MagentoEditPage extends PageObject {
    @FindBy(id = "product_info_tabs_reviews")
    private WebElement selectReviewTab;
    @FindBy(xpath = "//*[@id=\"reviwGrid_table\"]/tbody/tr[1]/td[3]")
    private WebElement latestProductReview;
    @FindBy(xpath = "//*[@id=\"status_id\"]")
    private WebElement changeStatus;
    @FindBy(xpath = "//*[@id=\"save_button\"]/span/span/span")
    private WebElement save;

    public void enterReviewTabAndChangeReviewStatus() {
        clickOn(selectReviewTab);
        clickOn(latestProductReview);
        selectFromDropdown(changeStatus, "Approved");
        clickOn(save);
    }
}
