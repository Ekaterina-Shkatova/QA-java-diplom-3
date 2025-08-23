package burgertest;

import steps.ApiSteps;
import steps.RegistrationSteps;
import browser.Browser;
import browser.BrowserClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import static browser.Browser.*;
import static burgertest.Resources.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    private WebDriver driver;

    public static Object[][] getData() {
        return new Object[][]{
                {CHROME},
                {YANDEX}
        };
    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Регистрация нового пользователя")
    @Description("Проверяем, что можно заеристрироваться с паролем не менее 6 символов")
    public void registerNewUserSuccess(Browser browserName) throws JsonProcessingException {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        RegistrationSteps registrationSteps = new RegistrationSteps(driver);
        registrationSteps.openRegistrationPage();
        registrationSteps.fillRegistrationForm(REGISTRATION_NAME, REGISTRATION_EMAIL, REGISTRATION_PASSWORD);
        registrationSteps.acceptRegistration();

        ApiSteps apiSteps = new ApiSteps();
        apiSteps.userDelete(REGISTRATION_EMAIL, REGISTRATION_PASSWORD).then().statusCode(202);

    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Регистрация нового пользователя с ошибкой")
    @Description("Проверяем, что нельзя зарегистрироваться менее 6 символов")
    public void registerNewUserPasswordError(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
         this.driver = driver;

        RegistrationSteps registrationSteps = new RegistrationSteps(driver);
        registrationSteps.openRegistrationPage();
        registrationSteps.fillRegistrationForm(REGISTRATION_NAME, REGISTRATION_EMAIL, REGISTRATION_PASSWORD_SHORT);
        registrationSteps.acceptRegistration();
        assertEquals("Некорректный пароль", registrationSteps.checkPasswordErrorMessage());

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
