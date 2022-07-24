package ru.yandex.praktikum;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.HomePage;
import ru.yandex.praktikum.pageobjects.OrderPage;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.startsWith;

public class OrderPageTest {

    HomePage home;
    OrderPage order;
    String statusSuccess = "Заказ оформлен";

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        home = open("https://qa-scooter.praktikum-services.ru/", HomePage.class);
        home.clickAcceptCookies();
        order = page(OrderPage.class);
    }

    @Test
    public void checkOrderInHeader() {
        home.clickOrderButtonInHeader();
        order.setOrderValue("Александр", "Голяков", "Академика Сахарова",
                "+79991112223", "16.05.2022", "Ты котик");
        MatcherAssert.assertThat(order.getOrderPlaceStatus(), startsWith(statusSuccess));
    }

    @Test
    public void checkOrderInBody() {
        home.clickOrderButtonInBody();
        order.setOrderValue("Александр", "Голяков", "Академика Сахарова",
                "+79991112223", "16.05.2022", "Ты котик");
        MatcherAssert.assertThat(order.getOrderPlaceStatus(), startsWith(statusSuccess));
    }

    @Test
    public void checkOrderInHeaderSecondValue() {
        home.clickOrderButtonInHeader();
        order.setOrderValue("Абдула", "Шахеризадов", "Адреснейм",
                "89991112223", "16.05.2022", "Я котик");
        MatcherAssert.assertThat(order.getOrderPlaceStatus(), startsWith(statusSuccess));
    }

    @Test
    public void checkOrderInBodySecondValue() {
        home.clickOrderButtonInBody();
        order.setOrderValue("Абдула", "Шахеризадов", "Адреснейм",
                "89991112223", "16.05.2022", "Я котик");
        MatcherAssert.assertThat(order.getOrderPlaceStatus(), startsWith(statusSuccess));
    }

    @After
    public void afterTest() {
        WebDriverRunner.closeWebDriver();
    }
}
