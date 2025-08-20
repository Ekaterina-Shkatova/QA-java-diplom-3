package burgertest;

import steps.ProfileSteps;
import browser.Browser;
import browser.BrowserClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import static browser.Browser.CHROME;
import static browser.Browser.YANDEX;
import static burgertest.Resources.*;
import static burgertest.Resources.REGISTRATION_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {

    private WebDriver driver;

    public static Object[][] getData() {
        return new Object[][]{
                {CHROME},
                {YANDEX}
        };
    }

    @BeforeEach
    public void initializationData() {
        api.ApiSteps apiSteps = new api.ApiSteps();
        apiSteps.userCreate(REGISTRATION_NAME, REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Переход в личный кабинет")
    @Description("Проверь переход по клику на Личный кабинет")
    public void openPersonalAccount(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ProfileSteps profileSteps = new ProfileSteps(driver);
        profileSteps.loginUser(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        profileSteps.clickPersonalAccount();

        assertEquals(PERSONAL_ACCOUNT_PAGE, driver.getCurrentUrl());

    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Переход по клику на Конструктор")
    @Description("Проверь переход по клику на Конструктор")
    public void clickConstructorFromPersonalAccount(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ProfileSteps profileSteps = new ProfileSteps(driver);
        profileSteps.loginUser(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        profileSteps.clickPersonalAccount();
        profileSteps.clickConstructor();

        assertEquals(MAIN_PAGE, driver.getCurrentUrl());

    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Переход по клику на логотип Stellar Burgers")
    @Description("Проверь переход по клику на логотип Stellar Burgers")
    public void clickLogoFromPersonalAccount(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ProfileSteps profileSteps = new ProfileSteps(driver);
        profileSteps.loginUser(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        profileSteps.clickPersonalAccount();
        profileSteps.clickLogo();

        assertEquals(MAIN_PAGE, driver.getCurrentUrl());

    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Выход из аккаунта")
    @Description("Проверь выход по кнопке Выйти в личном кабинете.")
    public void clickLogOutPersonalAccount(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ProfileSteps profileSteps = new ProfileSteps(driver);
        profileSteps.loginUser(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        profileSteps.clickPersonalAccount();
        profileSteps.clickLogout();

        assertEquals(LOGIN_PAGE, driver.getCurrentUrl());

    }

    @AfterEach
    public void tearDown() throws JsonProcessingException {
        driver.quit();

        api.ApiSteps apiSteps = new api.ApiSteps();
        apiSteps.userDelete(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
    }
}
