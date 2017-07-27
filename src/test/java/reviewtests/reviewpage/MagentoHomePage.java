package reviewtests.reviewpage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://qa3.madison.com/index.php/admin/index/index/key/b9ed11cbb3674abe7a30dff5ab0cf2ac/")
public class MagentoHomePage extends PageObject{
    @FindBy(css = "#username")
    private WebElement username;
    @FindBy(css = "#login")
    private WebElement password;
    @FindBy(css = ".form-button")
    private WebElement loginBtn;
    @FindBy(css = "[title=close]")
    private WebElement closeBtn;
    @FindBy(css = "#nav > li:nth-child(3)")
    private WebElement catalogBtn;
    @FindBy(css = "#nav > li:nth-child(3) > ul > li:nth-child(1) > a > span")
    private WebElement manageProductsBtn;

    public void openMagentoLogin(){
        getDriver().get("http://qa3.madison.com/index.php/admin/index/index/key/b9ed11cbb3674abe7a30dff5ab0cf2ac/");
    }
    public void login(String user, String pass){
        typeInto(username, user);
        typeInto(password, pass);
        clickOn(loginBtn);
        clickOn(closeBtn);
    }
    public void clickManageProducts(){
        Actions builder = new Actions(getDriver());
        builder.moveToElement(catalogBtn).build().perform();
        clickOn(manageProductsBtn);
    }
}
