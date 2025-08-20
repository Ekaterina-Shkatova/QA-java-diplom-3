package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class RegistrationSteps {

    private WebDriver driver;

    public RegistrationSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу регистрации")
    public void openRegistrationPage(){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.openRegistrationPage();
    }

    @Step("Зарегистрировать нового пользователя")
    public void fillRegistrationForm(String name, String email, String password){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.setName(name);
        objRegistrationPage.setEmail(email);
        objRegistrationPage.setPassword(password);
    }

    @Step("Подтвердить регистрацию")
    public void acceptRegistration(){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.clickRegistrationButton();
    }

    @Step("Проверить сообщение об ошибке длины пароля")
    public String checkPasswordErrorMessage(){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        return objRegistrationPage.passwordErrorMessageText();
    }

}
