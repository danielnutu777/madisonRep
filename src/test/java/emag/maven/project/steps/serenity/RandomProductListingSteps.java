package emag.maven.project.steps.serenity;

import emag.maven.project.pages.EmagHomePage;
import emag.maven.project.pages.ProductDetailsPage;
import emag.maven.project.pages.ProductListingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RandomProductListingSteps extends ScenarioSteps{
    private EmagHomePage emagHomePage;
    private ProductListingPage productListingPage;
    private ProductDetailsPage productDetailsPage;

    @Step
    public void openHomePage(){
        emagHomePage.open();
    }
    @Step
    public void listProducts(){
        emagHomePage.searchProducts("laptop");
    }
    @Step
    public void goToRandomPage(){
        productListingPage.getRandomPage();
    }
    @Step
    public void goToRandomProduct(){
        productListingPage.getRandomProduct();
    }
    @Step
    public void addToCartAndAssert(){
        productDetailsPage.addToCart();
    }
}
