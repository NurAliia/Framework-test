package app;

import app.pages.LoginPage;
import app.pages.CatalogPage;

public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("http://www.e-katalog.ru");
    }

    public static CatalogPage buildCatalogPage() {
        return new CatalogPage("http://www.e-katalog.ru");
    }
}
