package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    private By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    private By acceptLoginButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickAcceptLoginButton() {
        driver.findElement(acceptLoginButton).click();
    }

}
