package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import org.testng.Assert;
import java.util.List;
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

    public SelenideElement computers = $("a[href=\"/k169.htm\"]");
    public SelenideElement table = $("a[href=\"/k30.htm\"]");
    public SelenideElement maxPrice = $("#maxPrice_");
    public SelenideElement pagination = $("div.page-num");
    public SelenideElement lastPage = $("div.page-num a[last()]");
    public List<SelenideElement> tablets = $$("#list_form1 div");

    public void searchByPrice(String price) {
        computers.click();
        table.click();
        maxPrice.setValue(price);
        submit.scrollTo();
        submit.click();

        int pagesCount;

        try {
            pagination.scrollTo();
            pagesCount = Integer.parseInt(lastPage.getText());
        } catch (Exception ex) {
            pagesCount = 1;
        }

        for(int i = 0; i < pagesCount; i++) {
            boolean isLastPage = i == pagesCount - 1 ? true : false;
            checkPriceForPage(price, isLastPage);

            if(!isLastPage) {
                int next = i + 1;
                // Click next page
                $("//div[@class='ib page-num']/a[text()=" + next + "]").click();
            }
        }
    }

    public void checkPriceForPage(String price, Boolean isLastPage) {
        Assert.assertTrue(!tablets.isEmpty());

        if(!isLastPage) {
            tablets.remove(tablets.size() - 1);
        }

        for (SelenideElement tablet: tablets) {
            int ind = tablets.indexOf(tablet);
            checkTabletPriceLower(tablet, price, ind);
        }
    }

    public void checkTabletPriceLower(SelenideElement tablet, String price, Integer i) {
        SelenideElement minPrice;
        int priceInt = Integer.parseInt(price);

        minPrice = tablet.$("div.model-price-range a span[1]");

        System.out.println(minPrice);
        System.out.println(priceInt >
                Integer.parseInt(minPrice.getText().replace(" ", "")));

        Assert.assertTrue(priceInt >
                Integer.parseInt(minPrice.getText().replace(" ", "")));
    }
}