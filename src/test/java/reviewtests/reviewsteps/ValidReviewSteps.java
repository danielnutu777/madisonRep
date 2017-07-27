package reviewtests.reviewsteps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import reviewtests.reviewpage.*;

import java.awt.*;

public class ValidReviewSteps extends ScenarioSteps {
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductDetailsPage productDetailsPage;
    private ReviewPage reviewPage;
    private MagentoHomePage magentoHomePage;
    private MagentoManageProductsPage magentoManageProductsPage;
    private MagentoEditPage magentoEditPage;

    private String title;
    private String url;

    @Step
    public void goToHomePage() {
        homePage.open();
    }
    @Step
    public void showSearchResults() {
        homePage.enterProductAndClick("shirt");
    }
    @Step
    public void clickOnSelectedProduct() {
        searchResultPage.selectRandomProduct();
    }
    @Step
    public void enterReviewSection() {
        productDetailsPage.clickOnReviews();
        title = productDetailsPage.getProductName();
        url = productDetailsPage.getLink();
    }
    @Step
    public void checkReviewRadioButtonsAndEnterText() {
        reviewPage.addReviewStars("test", "test", "test");
    }
    @Step
    public void assertReviewMsg() {
        reviewPage.compareConfirmationMsgs();
    }


    @Step
    public void openMagento(){
        magentoHomePage.openMagentoLogin();
    }
    @Step
    public void loginMagento(){
        magentoHomePage.login("admin", "parola11");
    }
    @Step
    public void enterManageProducts(){
        magentoHomePage.clickManageProducts();
    }
    @Step
    public void searchProductName() throws AWTException {
        magentoManageProductsPage.searchProduct(title);
    }
    @Step
    public void displayReviewOnSite(){
        magentoEditPage.enterReviewTabAndChangeReviewStatus();
    }
    @Step
    public void confirmReviewIsDisplayed(){
        productDetailsPage.assertReviewMsg(url);
    }
}

