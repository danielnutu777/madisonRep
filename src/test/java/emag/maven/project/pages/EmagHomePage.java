package emag.maven.project.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.emag.ro/")
public class EmagHomePage extends PageObject{
    @FindBy(className = "gtm_search_bar_click_search_week")
    private WebElement searchBar;
    @FindBy(className = "icon-i10-search")
    private WebElement searchBtn;

    public void searchProducts(String product){
        typeInto(searchBar, product);
        waitABit(2000);
        clickOn(searchBtn);
    }
}
