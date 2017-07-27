package emag.maven.project.features.tests;

import emag.maven.project.steps.serenity.RandomProductListingSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RandomProductListingTest {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    RandomProductListingSteps randomProductListingSteps;

    @Before
    public void maximizeWindow(){
        webDriver.manage().window().maximize();
    }

    @Test
    public void listRandomProductTest(){
        randomProductListingSteps.openHomePage();
        randomProductListingSteps.listProducts();
        randomProductListingSteps.goToRandomPage();
        randomProductListingSteps.goToRandomProduct();
        randomProductListingSteps.addToCartAndAssert();
    }
}
