package StepDef;

import MyFinalProject.Base;
import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class StepDef1 extends Base {

    HomePage h = new HomePage();
    CheckOutPage cp = new CheckOutPage();
    CartPage cartResults = new CartPage();

    @Given("^User navigates to website$")
    public void user_navigates_to_website() throws Throwable {
        Base.getDriver();
       // Base.driver.get(Base.prop.getProperty("url"));

    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String arg1) throws Throwable {


        h.getSearch().sendKeys(arg1);
        Thread.sleep(3000);
    }

    @Then("^\"([^\"]*)\" result is displayed$")
    public void result_is_displayed(String arg1) throws Throwable {

        Assert.assertTrue(h.getProductName().getText().contains(arg1));

    }

    @When("^User searches for \"([^\"]*)\" vegetable$")
    public void user_searches_for_vegetable(String arg1) throws Throwable {
        h.getSearch().sendKeys(arg1);
    }


    @When("^Added to the cart$")
    public void added_to_the_cart() throws Throwable {

          HomePage h = PageFactory.initElements(Base.driver,HomePage.class);
          h.increment();
          h.setToCart();
    }

    @When("^User proceeds to the checkOut page$")
    public void user_proceeds_to_the_checkOut_page() throws Throwable {
        cp.getImage().click();
        Thread.sleep(2000);
        cp.getProceedTocheckout().click();
        Thread.sleep(2000);
    }


    @Then("^Verify selected \"([^\"]*)\" are displayed in the Checkout Page$")
    public void verify_selected_are_displayed_in_the_Checkout_Page(String arg1) throws Throwable {

        //Assert.assertTrue(cartResults.getPass().getText().contains(arg1));
        Thread.sleep(2000);
        System.out.println(arg1);
    }


    @When("^User added more than one item to the cart$")
    public void user_added_more_than_one_item_to_the_cart() throws Throwable {
       String[] itemsNeeded = {"Cucumber - 1 Kg", "Beetroot - 1 Kg", "Broccoli - 1 Kg"};

       Thread.sleep(2000);
       List<WebElement> products = h.getSelects();

       for(int i = 0; i<products.size(); i++){
           String name = products.get(i).getText();
           List itemNeededList = Arrays.asList(itemsNeeded);

           if(itemNeededList.contains(name)){
               h.addCartLists().get(i).click();
           }

       }
    }

    @Then("^Verify selected items are displayed in the Checkout Page$")
    public void verify_selected_items_are_displayed_in_the_Checkout_Page() throws Throwable {

    }




}
