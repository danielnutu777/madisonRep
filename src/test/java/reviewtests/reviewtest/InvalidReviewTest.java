package reviewtests.reviewtest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import reviewtests.reviewsteps.InvalidReviewSteps;

@RunWith(SerenityRunner.class)
public class InvalidReviewTest {
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    InvalidReviewSteps invalidReviewSteps;

    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Test
    public void submitInvalidReview(){
        invalidReviewSteps.goToHomePage();
        invalidReviewSteps.showSearchResults();
        invalidReviewSteps.clickOnSelectedProduct();
        invalidReviewSteps.enterReviewSection();
        invalidReviewSteps.submitReviewWithoutRating();
        invalidReviewSteps.assertRatingWarningMsg();
        invalidReviewSteps.submitReviewWithoutThoughts();
        invalidReviewSteps.assertThoughtsWarningMsg();
        invalidReviewSteps.submitReviewWithoutSummary();
        invalidReviewSteps.assertSummaryWarningMsg();
        invalidReviewSteps.submitReviewWithoutNickname();
        invalidReviewSteps.assertNicknameWarningMsg();
    }
}
