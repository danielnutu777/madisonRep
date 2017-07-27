package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Random;

@DefaultUrl("http://qa3.madison.com/")
public class SearchResultPage extends PageObject{

    @FindBy(css = "[id^='product-collection-image-']")
    List<WebElement> productList;

    Random rand = new Random();
    public void selectRandomProduct() {
        int productNumber = rand.nextInt(productList.size());
        productList.get(productNumber).click();
    }
}

