package app;

import app.pages.LoginPage;

public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("http://www.e-katalog.ru");
    }
}
