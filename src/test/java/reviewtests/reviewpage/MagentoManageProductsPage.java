package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import reviewtests.reviewsteps.ValidReviewSteps;

@DefaultUrl("http://qa3.madison.com/index.php/admin/index/index/key/b9ed11cbb3674abe7a30dff5ab0cf2ac/")
public class MagentoManageProductsPage extends PageObject{

    @FindBy(id = "productGrid_product_filter_name")
    WebElement searchField;

    public void searchProduct(String s){
        searchField.sendKeys(s);
    }
}
