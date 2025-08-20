package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static burgertest.Resources.MAIN_PAGE;

public class MainPage {

    private WebDriver driver;

    private By buttonPersonalAccount = By.xpath(".//a[@href='/account']");
    private By buttonLoginMainPage = By.xpath(".//button[text()='Войти в аккаунт']");

    private By listBuns = By.xpath(".//div[./span[text()='Булки']]");
    private By listSouses = By.xpath(".//div[./span[text()='Соусы']]");
    private By listiFllins = By.xpath(".//div[./span[text()='Начинки']]");

    private By firstItemBuns = By.xpath(".//p[text()='Флюоресцентная булка R2-D3']");
    private By firstItemSouses = By.xpath(".//p[text()='Соус Spicy-X']");
    private By firstItemFillins = By.xpath(".//p[text()='Мясо бессмертных моллюсков Protostomia']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public void openMainPage(){
        driver.get(MAIN_PAGE);
    }

    public void clickPersonalAccount(){
        driver.findElement(buttonPersonalAccount).click();
    }

    public void clickLogin(){
        driver.findElement(buttonLoginMainPage).click();
    }

    public void clickBuns(){
        driver.findElement(listBuns).click();
    }

    public void clickSouses(){
        driver.findElement(listSouses).click();
    }

    public void clickFllins(){
        driver.findElement(listiFllins).click();
    }

    public boolean firstItemBunsVisible(){
        return driver.findElement(firstItemBuns).isDisplayed();
    }

    public boolean firstItemSousesVisible(){
        return driver.findElement(firstItemSouses).isDisplayed();
    }

    public boolean firstItemFllinsVisible(){
        return driver.findElement(firstItemFillins).isDisplayed();
    }
}
