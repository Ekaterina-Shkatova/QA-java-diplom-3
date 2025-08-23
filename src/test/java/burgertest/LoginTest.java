package burgertest;

import steps.ApiSteps;
import steps.LoginSteps;
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
import pages.LoginPageType;

import static browser.Browser.*;
import static burgertest.Resources.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pages.LoginPageType.*;

public class LoginTest {

    private WebDriver driver;

    public static Object[][] getData() {
        return new Object[][]{
                {CHROME, LOGIN_MAIN_PAGE},
                {CHROME, LOGIN_PERSONAL_ACCOUNT},
                {CHROME, LOGIN_REGISTRATION_PAGE},
                {CHROME, LOGIN_RESTORE_PASSWORD_PAGE},
                {YANDEX, LOGIN_MAIN_PAGE},
                {YANDEX, LOGIN_PERSONAL_ACCOUNT},
                {YANDEX, LOGIN_REGISTRATION_PAGE},
                {YANDEX, LOGIN_RESTORE_PASSWORD_PAGE}
        };
    }

    @BeforeEach
    public void initializationData(){
        ApiSteps apiSteps = new ApiSteps();
        apiSteps.userCreate(REGISTRATION_NAME, REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Логин пользователя")
    @Description("Проверяем, что можно залогиниться пользователем разнами способами")
    public void loginUser(Browser browserName, LoginPageType loginPageType) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.openLoginPage(loginPageType);
        loginSteps.fillInLoginForm(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        loginSteps.acceptLoginButton();
        // после успешного входа должны перейти на главную страницу
        assertEquals(MAIN_PAGE, driver.getCurrentUrl());

    }

    @AfterEach
    public void tearDown() throws JsonProcessingException {
        driver.quit();

        ApiSteps apiSteps = new ApiSteps();
        apiSteps.userDelete(REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
    }

}
