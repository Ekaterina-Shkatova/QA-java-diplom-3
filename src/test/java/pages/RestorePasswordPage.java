package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static burgertest.Resources.RESTORE_PASSWORD_PAGE;

public class RestorePasswordPage {

    private WebDriver driver;

    private By loginButton = By.xpath(".//a[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRestorePasswordPage(){
        driver.get(RESTORE_PASSWORD_PAGE);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }


}
