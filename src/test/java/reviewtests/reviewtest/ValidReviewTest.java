package reviewtests.reviewtest;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import reviewtests.reviewsteps.ValidReviewSteps;

import java.awt.*;

@RunWith(SerenityRunner.class)
public class ValidReviewTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private ValidReviewSteps validReviewSteps;

    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Test
    public void submitValidReview() throws AWTException {
        validReviewSteps.goToHomePage();
        validReviewSteps.showSearchResults();
        validReviewSteps.clickOnSelectedProduct();
        validReviewSteps.enterReviewSection();
        validReviewSteps.checkReviewRadioButtonsAndEnterText();
        validReviewSteps.assertReviewMsg();

        validReviewSteps.openMagento();
        validReviewSteps.loginMagento();
        validReviewSteps.enterManageProducts();
        validReviewSteps.searchProductName();
        validReviewSteps.displayReviewOnSite();
        validReviewSteps.confirmReviewIsDisplayed();
    }
}
