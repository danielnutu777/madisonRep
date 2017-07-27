package reviewtests.reviewsteps;

import net.thucydides.core.annotations.Step;
import reviewtests.reviewpage.HomePage;
import reviewtests.reviewpage.ProductDetailsPage;
import reviewtests.reviewpage.ReviewPage;
import reviewtests.reviewpage.SearchResultPage;

public class InvalidReviewSteps {
    ReviewPage reviewPage;
    HomePage homePage;
    SearchResultPage searchResultPage;
    ProductDetailsPage productDetailsPage;

    @Step
    public void goToHomePage(){
        homePage.open();
    }
    @Step
    public void showSearchResults(){
        homePage.enterProductAndClick("shirt");
    }
    @Step
    public void clickOnSelectedProduct(){
        searchResultPage.selectRandomProduct();
    }
    @Step
    public void enterReviewSection(){
        productDetailsPage.clickOnReviews();
    }
    @Step
    public void submitReviewWithoutRating(){
        reviewPage.enterTextInFields("test", "test", "test");
    }
    @Step
    public void assertRatingWarningMsg(){
        reviewPage.assertRatingMsg();
    }
    @Step
    public void submitReviewWithoutThoughts(){
        reviewPage.addRatingAndEnterTextInTwoFields("test", "test");
    }
    @Step
    public void assertThoughtsWarningMsg(){
        reviewPage.assertThoughtsMsg();
    }
    @Step
    public void submitReviewWithoutSummary(){
        reviewPage.addRatingAndEnterTextInOtherTwoFields("test", "test");
    }
    @Step
    public void assertSummaryWarningMsg(){
        reviewPage.assertSummaryMsg();
    }
    @Step
    public void submitReviewWithoutNickname(){
        reviewPage.addRatingAndLastTwoFields("test", "test");
    }
    @Step
    public void assertNicknameWarningMsg(){
        reviewPage.assertNicknameMsg();
    }
}
