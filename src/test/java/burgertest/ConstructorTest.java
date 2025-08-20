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
    @DisplayName("Раздел Конструктор")
    @Description("Проверяем, что работают переходы к разделам")
    public void checkConstructorList(Browser browserName) {

        BrowserClass browserClass = new BrowserClass();
        WebDriver driver = browserClass.getWebDriver(browserName);
        this.driver = driver;

        ConstructorSteps constructorSteps = new ConstructorSteps(driver);
        constructorSteps.openConstructorPage();

        boolean bunsVisible = constructorSteps.checkBuns();
        assertTrue(bunsVisible, "Переход к булкам не работает");

        boolean sousesVisible = constructorSteps.checkSouses();
        assertTrue(sousesVisible, "Переход к соусам не работает");

        boolean fillinsVisible = constructorSteps.checkFilling();
        assertTrue(fillinsVisible, "Переход к начинкам не работает");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
