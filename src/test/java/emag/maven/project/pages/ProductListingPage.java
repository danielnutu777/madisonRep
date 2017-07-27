package emag.maven.project.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

@DefaultUrl("https://www.emag.ro/")
public class ProductListingPage extends PageObject{
    @FindBy(xpath = "//*[@id=\"emg-pagination-numbers\"]/a[5]")
    private List<WebElement> maxPages;
    @FindBy(css = ".lazy")
    private List<WebElement> products;

    private Random rand = new Random();
    public void getRandomPage() {
        String searchedProduct = "laptop";
        int noOfPages;
        noOfPages = Integer.parseInt(maxPages.get(maxPages.size()-1).getText());
        System.out.println(noOfPages);
        int pageNumber = rand.nextInt(noOfPages) + 1;
        System.out.println(pageNumber);
        getDriver().navigate().to("https://emag.ro/search/" + searchedProduct + "/p" + pageNumber);
        waitABit(2000);
    }
    public void getRandomProduct() {
        int product = rand.nextInt(products.size()) - 1;
        System.out.println(product);
        products.get(product).click();
    }
}
