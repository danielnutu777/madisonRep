package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

@DefaultUrl("http://qa3.madison.com/index.php/admin/index/index/key/b9ed11cbb3674abe7a30dff5ab0cf2ac/")
public class MagentoManageProductsPage extends PageObject {

    @FindBy(id = "productGrid_product_filter_name")
    private WebElement searchField;
    @FindBy(id = "productGrid_product_filter_type")
    private WebElement type;
    @FindBy(id = "productGrid_product_filter_status")
    private WebElement status;
    @FindBy(id = "productGrid_product_filter_websites")
    private WebElement websites;
    @FindBy(xpath = "//*[@id=\"productGrid_table\"]/tbody/tr/td[3]")
    private WebElement editBtn;

    public void searchProduct(String s) throws AWTException {

        try {
            Robot robot = new Robot();
            searchField.sendKeys(s);
            selectFromDropdown(type, "Configurable Product");
            selectFromDropdown(status, "Enabled");
            selectFromDropdown(websites, "Main Website");

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            waitABit(3000);
            editBtn.click();
            waitABit(3000);

        }catch (Exception e) {
            Robot robot = new Robot();
            selectFromDropdown(type, "Simple Product");
            selectFromDropdown(status, "Enabled");
            selectFromDropdown(websites, "Main Website");

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            waitABit(3000);
            editBtn.click();
            waitABit(3000);
        }
    }
}
