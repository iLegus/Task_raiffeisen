package cucumber;

import com.codeborne.selenide.Configuration;

import cucumber.api.java.ru.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;


import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class YandexStepsdefs {
    private String keyword;


    @Дано("открыть браузер яндекс")
    public void openGoogleSearch() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "target/surefire-reports";
        System.setProperty("webdriver.chrome.driver", "C:\\project\\cucumber\\src\\test\\resources\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("https://yandex.ru/");
    }

    @Когда("перейти во вкладку (.*)")
    public void перейти_в_маркет(String tab) {
        $(By.xpath(".//a[text()='" + tab + "']")).click();
    }

    @Когда("выбрать категорию (.*)")
    public void выбрать_категорию_мобильные_телефоны(String category) {
        $(By.xpath(".//span[text()='Все категории']")).click();
        $(By.xpath(".//a[text()='" + category + "']")).click();
    }

    @Когда("выбрать производителя (.*)")
    public void выбрать_xiaomi(String vendor) {
        $(By.xpath(".//span[text()='" + vendor + "']")).click();
    }

    @Когда("выбрать модель (.*)")
    public void выбрать_телефон(String model) {
        boolean b = false;
        while (!b) {
            if ($(By.xpath(".//a[text()='Смартфон " + model + "']")).isDisplayed()) {
                $(By.xpath(".//a[text()='Смартфон " + model + "']")).click();
                b = true;
            } else {
                $(By.xpath(".//div[@class='pager-more__button pager-loader_preload']")).click();
            }
        }
    }

    @Когда("^проверить характеристики$")
    public void проверить_характеристики(DataTable arg) {

        List<Map<String, String>> table = arg.asMaps(String.class, String.class);
        table.forEach((temp) ->
        {
            $(By.xpath("//span[text()='" + temp.get("Характеристика") + "']/ancestor::*[2]/dd/span")).shouldHave(text(temp.get("Значение")));
        });

    }

    @Когда("открыть вкладку карточки товара (.*)")
    public void открыть_вкладку_карточки_товара(String tab) {
        $(By.xpath(".//a[text()='" + tab + "']")).click();

    }

}
