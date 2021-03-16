package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import static com.codeborne.selenide.Selenide.*;

public class CatalogPage extends BasePage {

    public SelenideElement gadgets = $("a[href=\"/k119.htm\"]");
    public SelenideElement actionCamera = $("a[href=\"/k695.htm\"]");
    public SelenideElement sony = $("#li_br156");
    public SelenideElement description = $("#preset_t_18920");
    public SelenideElement nfc = $("#c17983~label");

    public CatalogPage(String pageUrl) {
        super(pageUrl);
    }

    public void gadgets() {
        gadgets.click();
        actionCamera.click();

        sony.click();
        description.scrollTo();
        nfc.click();
//        Driver.waitForUrlContains("idwu_=");
    }
}