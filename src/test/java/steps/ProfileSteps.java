package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

import java.time.Duration;

import static burgertest.Resources.*;

public class ProfileSteps {

    private WebDriver driver;

    public ProfileSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Выполнить вход")
    public void loginUser(String email, String password){

        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickLogin();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.setEmail(email);
        objLoginPage.setPassword(password);
        objLoginPage.clickAcceptLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE));
    }

    @Step("Перейти в личный кабинет")
    public void clickPersonalAccount(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickPersonalAccount();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(PERSONAL_ACCOUNT_PAGE));

    }

    @Step("Перейти по клику на Конструктор")
    public void clickConstructor() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructor();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE));

    }

    @Step("Перейти по клику на логотип Stellar Burgers")
    public void clickLogo() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogo();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(MAIN_PAGE));

    }

    @Step("Выйти из аккаунта")
    public void clickLogout() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogout();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(LOGIN_PAGE));

    }
}
