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
    private MagentoEditPage magentoEditPage;
    private MagentoReviewPage magentoReviewPage;

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
        magentoReviewPage.enterReviewSection();
    }
    @Step
    public void displayReviewOnSite(){
        magentoEditPage.enterReviewTabAndChangeReviewStatus();
    }
    @Step
    public void confirmReviewIsDisplayed(){
        productDetailsPage.assertReviewMsg(url);
    }
    @Step
    public void deleteReview(){
        magentoReviewPage.getMagentoReviewPage();
        magentoReviewPage.enterReviewSection();
        magentoEditPage.deleteReview();
    }
    @Step
    public void assertDeletedReview(){
        magentoReviewPage.assertReviewMsgIsDeleted(url);
    }
}

