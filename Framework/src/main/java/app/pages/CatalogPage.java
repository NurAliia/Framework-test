package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;

public class CatalogPage extends BasePage {

    public SelenideElement gadgets = $("a[href=\"/k119.htm\"]");
    public SelenideElement actionCamera = $("a[href=\"/k695.htm\"]");
    public SelenideElement sony = $("#li_br156");
    public SelenideElement description = $("#preset_t_18920");
    public SelenideElement nfc = $("#c17983~label");
    public SelenideElement submit = $("#match_submit");
    public SelenideElement camera = $("#product_918494");
    public SelenideElement favorite = $("span.heart-empty");
    public SelenideElement portfolio = $("#mui_user_login_row");
    public SelenideElement favoriteList = $("div.touchcarousel-item a[href=\"/SONY-HDR-AS300.htm\"]");
    public SelenideElement removeFavorite = $("div.touchcarousel-item div.whishlist-action--remove");

    public CatalogPage(String pageUrl) {
        super(pageUrl);
    }

    public void gadgets() {
        gadgets.click();
        actionCamera.click();

        sony.click();
        description.scrollTo();
        nfc.click();
        submit.scrollTo();
        submit.click();
        camera.click();
        favorite.click();
        portfolio.click();
        favoriteList.shouldBe(visible);

        $("div.touchcarousel-item").hover();
        removeFavorite.click();
    }
}