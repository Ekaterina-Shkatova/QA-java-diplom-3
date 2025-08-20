package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static burgertest.Resources.*;

public class RegistrationPage {

    private WebDriver driver;

    private By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    private By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    private By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By loginButton = By.xpath(".//a[@href='/login']");
    private By passwordErrorMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRegistrationPage(){
        driver.get(REGISTRATION_PAGE);
    }

    public void setName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String passwordErrorMessageText(){
        return driver.findElement(passwordErrorMessage).getText();
    }

}
