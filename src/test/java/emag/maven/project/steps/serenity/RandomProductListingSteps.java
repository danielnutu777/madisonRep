package emag.maven.project.steps.serenity;

import emag.maven.project.pages.RandomProductListingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RandomProductListingSteps extends ScenarioSteps{
    RandomProductListingPage randomProductListingPage;
    @Step
    public void openHomePage(){
        randomProductListingPage.open();
    }
    @Step
    public void listProducts(){
        randomProductListingPage.searchProducts("iphone 7");
    }
    @Step
    public void goToRandomPage(){
        randomProductListingPage.getRandomPage();
    }
    @Step
    public void goToRandomProduct(){
        randomProductListingPage.getRandomProduct();
    }
    @Step
    public void addToCartAndAssert(){
        randomProductListingPage.addToCart();
    }
}
