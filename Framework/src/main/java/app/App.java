package app;

import app.pages.LoginPage;
import app.pages.CatalogPage;

public class App {

    public LoginPage loginPage;
    public CatalogPage catalogPage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
        catalogPage = PageBuilder.buildCatalogPage();
    }
}
