package reviewtests.reviewsteps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import reviewtests.reviewpage.*;

public class ValidReviewSteps extends ScenarioSteps {
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;
    ReviewPage reviewPage;
    MagentoHomePage magentoHomePage;
    MagentoManageProductsPage magentoManageProductsPage;

    public String title;

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
    }

    @Step
    public void checkReviewRadioButtonsAndEnterText() {
        reviewPage.addReviewStars("sdasd", "asdasd", "asdasdasd");
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
    public void searchProductName(){
        magentoManageProductsPage.searchProduct(title);
    }
}

