package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://qa3.madison.com/")
public class HomePage extends PageObject {
    @FindBy(id = "search")
    private WebElement searchBar;
    @FindBy(className = "search-button")
    private WebElement searchBtn;

    public void enterProductAndClick(String product) {
        typeInto(searchBar, product);
        clickOn(searchBtn);
    }
}


