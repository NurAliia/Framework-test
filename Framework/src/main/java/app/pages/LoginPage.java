package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    public SelenideElement enterButton = $("span.wu_entr");
    public SelenideElement registryButton = $("div.signin-with-reg span.j-wrap");
    public SelenideElement nameField = $("div.registration-name input");
    public SelenideElement emailField = $("div.registration-email input");
    public SelenideElement passwordField = $("div.registration-password input");
    public SelenideElement signInButton = $("div.registration-actions button[type=\"submit\"]");
    public SelenideElement profile = $("#mui_user_login_row a");

    public SelenideElement logoutButton = $("a.help2");

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    public void login(String name, String email, String password) {
        enterButton.click();
        registryButton.click();
        nameField.setValue(name);
        emailField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        profile.click();
        Driver.waitForUrlContains("idwu_=");
    }

    public void logout() {
        logoutButton.click();
    }
}
