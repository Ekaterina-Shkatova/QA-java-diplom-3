package burgertest;

import steps.ConstructorSteps;
import browser.Browser;
import browser.BrowserClass;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import static browser.Browser.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTest {

    private WebDriver driver;

    public static Object[][] getData() {
        return new Object[][]{
                {CHROME},
                {YANDEX}
        };
    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Раздел Конструктор Булки")
    @Description("Проверяем, что работает переход к разделу Булки")
    public void checkConstructorBuns(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ConstructorSteps constructorSteps = new ConstructorSteps(driver);
        constructorSteps.openConstructorPage();

        boolean bunsSelected = constructorSteps.checkBuns();
        assertTrue(bunsSelected, "Переход к булкам не работает");
    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Раздел Конструктор Соусы")
    @Description("Проверяем, что работает переход к разделу Соусы")
    public void checkConstructorSouses(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ConstructorSteps constructorSteps = new ConstructorSteps(driver);
        constructorSteps.openConstructorPage();

        boolean sousesSelected = constructorSteps.checkSouses();
        assertTrue(sousesSelected, "Переход к соусам не работает");

    }

    @ParameterizedTest
    @MethodSource("getData")
    @DisplayName("Раздел Конструктор Начинки")
    @Description("Проверяем, что работает переход к разделу Начинки")
    public void checkConstructorFillins(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ConstructorSteps constructorSteps = new ConstructorSteps(driver);
        constructorSteps.openConstructorPage();

        boolean fillinsSelected = constructorSteps.checkFilling();
        assertTrue(fillinsSelected, "Переход к начинкам не работает");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
