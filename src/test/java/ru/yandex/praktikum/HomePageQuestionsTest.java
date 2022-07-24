package ru.yandex.praktikum;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class HomePageQuestionsTest {

    HomePage home;

    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        home = open("https://qa-scooter.praktikum-services.ru/", HomePage.class);
        home.clickAcceptCookies();
    }

    @Test
    public void check1Answer() {
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actual = home.getAnswer(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void check2Answer() {
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете " +
                "просто сделать несколько заказов — один за другим.";
        String actual = home.getAnswer(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void check3Answer() {
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт " +
                "времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая" +
                " в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actual = home.getAnswer(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void check4Answer() {
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actual = home.getAnswer(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void check5Answer() {
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому " +
                "номеру 1010.";
        String actual = home.getAnswer(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void check6Answer() {
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете" +
                " кататься без передышек и во сне. Зарядка не понадобится.";
        String actual = home.getAnswer(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void check7Answer() {
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. " +
                "Все же свои.";
        String actual = home.getAnswer(6);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void check8Answer() {
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actual = home.getAnswer(7);
        Assert.assertEquals(expected, actual);
    }

    @After
    public void afterTest() {
        WebDriverRunner.closeWebDriver();
    }
}
