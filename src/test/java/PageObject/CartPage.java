package PageObject;

import MyFinalProject.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage {

    public By productName = By.cssSelector("p.product-name");

    public WebElement getPass() throws InterruptedException {

        Thread.sleep(2000);
        return Base.driver.findElement(productName);

    }
}
