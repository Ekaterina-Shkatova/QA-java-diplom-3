package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class ConstructorSteps {

    private WebDriver driver;

    public ConstructorSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти на страницу конструктора")
    public void openConstructorPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @Step("Проверить булки")
    public boolean checkBuns(){
        MainPage mainPage = new MainPage(driver);
        // булки первые, для их проверки сначала нужно перейти в другой раздел
        mainPage.clickFllins();
        mainPage.clickBuns();
        return mainPage.firstItemBunsVisible() && mainPage.bunsTabActivated();
    }

    @Step("Проверить соусы")
    public boolean checkSouses(){
        MainPage mainPage = new MainPage(driver);
        // соусы видны сразу, для их проверки сначала нужно перейти в другой раздел
        mainPage.clickFllins();
        mainPage.clickSouses();
        return mainPage.firstItemSousesVisible() && mainPage.sousesTabActivated();
    }

    @Step("Проверить начинки")
    public boolean checkFilling(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFllins();
        return mainPage.firstItemFllinsVisible() && mainPage.fillinsTabActivated();
    }


}
