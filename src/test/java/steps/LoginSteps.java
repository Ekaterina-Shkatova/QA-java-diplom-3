package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;

import static burgertest.Resources.*;
import static pages.LoginPageType.*;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу и нажать кнопку для входа")
    public void openLoginPage(LoginPageType loginPageType){
        if (loginPageType == LOGIN_MAIN_PAGE){
            MainPage objMainPage = new MainPage(driver);
            objMainPage.openMainPage();
            objMainPage.clickLogin();
        } else if (loginPageType == LOGIN_PERSONAL_ACCOUNT) {
            MainPage objMainPage = new MainPage(driver);
            objMainPage.openMainPage();
            objMainPage.clickPersonalAccount();
        } else if (loginPageType == LOGIN_REGISTRATION_PAGE) {
            RegistrationPage objRegistrationPage = new RegistrationPage(driver);
            objRegistrationPage.openRegistrationPage();
            objRegistrationPage.clickLoginButton();
        } else if (loginPageType == LOGIN_RESTORE_PASSWORD_PAGE) {
            RestorePasswordPage objRestorePasswordPage = new RestorePasswordPage(driver);
            objRestorePasswordPage.openRestorePasswordPage();
            objRestorePasswordPage.clickLoginButton();
        }
    }

    @Step("Заполнить форму входа")
    public void fillInLoginForm(String email, String password){
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
    }

    @Step("Подтвердить вход")
    public void acceptLoginButton(){
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickAcceptLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE));
    }
}
