package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static burgertest.Resources.PERSONAL_ACCOUNT_PAGE;

public class ProfilePage {

    private WebDriver driver;

    private By logoButton = By.xpath(".//div[contains(@class, 'logo')]");
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logoutButton = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openProfilePage() {
        driver.get(PERSONAL_ACCOUNT_PAGE);
    }

    public void clickLogo() {
        driver.findElement(logoButton).click();
    }

    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

}
