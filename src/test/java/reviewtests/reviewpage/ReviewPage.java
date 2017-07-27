package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

@DefaultUrl("http://qa3.madison.com/")
public class ReviewPage extends PageObject{
    @FindBy(css = ".first.odd .value")
    List<WebElement> qualityRating;
    @FindBy(css = "tr[class = even] .value")
    List<WebElement> priceRating;
    @FindBy(css = ".last.odd .value")
    List<WebElement> valueRating;
    @FindBy(css = "#review_field")
    WebElement field1;
    @FindBy(css = "#summary_field")
    WebElement field2;
    @FindBy(css = "#nickname_field")
    WebElement field3;
    @FindBy(css = ".buttons-set [type=submit]")
    WebElement submitBtn;
    @FindBy(css = ".messages")
    WebElement confirmationMsg;
    @FindBy(css = "#advice-validate-rating-validate_rating")
    WebElement ratingError;
    @FindBy(css = "#advice-required-entry-review_field")
    WebElement thoughtsError;
    @FindBy(css = "#advice-required-entry-summary_field")
    WebElement summaryError;
    @FindBy(css = "#advice-required-entry-nickname_field")
    WebElement nicknameError;

    Random rand = new Random();
    public void addReviewStars(String s1, String s2, String s3) {
        qualityRating.get(rand.nextInt(qualityRating.size())).click();
        priceRating.get(rand.nextInt(priceRating.size())).click();
        valueRating.get(rand.nextInt(valueRating.size())).click();

        typeInto(field1, s1);
        typeInto(field2, s2);
        typeInto(field3, s3);
        clickOn(submitBtn);
    }
    public void compareConfirmationMsgs(){
        String assertMsg = confirmationMsg.getText();
        Assert.assertEquals(assertMsg, "Your review has been accepted for moderation.");
    }
    public void enterTextInFields(String s1, String s2, String s3) {
        typeInto(field1, s1);
        typeInto(field2, s2);
        typeInto(field3, s3);
        clickOn(submitBtn);
    }
    public void assertRatingMsg() {
        waitABit(3000);
        String s = ratingError.getText();
        Assert.assertEquals(s, "Please select one of each of the ratings above");
    }
    public void addRatingAndEnterTextInTwoFields(String s2, String s3) {
        field1.clear();
        field2.clear();
        field3.clear();

        selectRating();

        typeInto(field2, s2);
        typeInto(field3, s3);
        clickOn(submitBtn);
    }
    public void assertThoughtsMsg() {
        String s = thoughtsError.getText();
        Assert.assertEquals(s, "THIS IS A REQUIRED FIELD.");
    }

    public void addRatingAndEnterTextInOtherTwoFields(String s1, String s3) {
        field2.clear();
        field3.clear();

        selectRating();

        typeInto(field1, s1);
        typeInto(field3, s3);
        clickOn(submitBtn);
    }

    public void assertSummaryMsg() {
        String s = summaryError.getText();
        Assert.assertEquals(s, "THIS IS A REQUIRED FIELD.");
    }

    public void addRatingAndLastTwoFields(String s1, String s2) {
        field1.clear();
        field3.clear();

        selectRating();

        typeInto(field1, s1);
        typeInto(field2, s2);
        clickOn(submitBtn);
    }

    public void assertNicknameMsg() {
        String s = nicknameError.getText();
        Assert.assertEquals(s, "THIS IS A REQUIRED FIELD.");
    }

    public void selectRating() {
        waitFor(qualityRating.get(0));
        qualityRating.get(rand.nextInt(qualityRating.size())).click();
        priceRating.get(rand.nextInt(priceRating.size())).click();
        valueRating.get(rand.nextInt(valueRating.size())).click();
    }
}
