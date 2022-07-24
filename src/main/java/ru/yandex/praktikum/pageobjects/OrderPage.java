package ru.yandex.praktikum.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;

public class OrderPage {
    //Поле "Имя"
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Имя']")
    private SelenideElement inputName;

    //Поле "Фамилия"
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Фамилия']")
    private SelenideElement inputSurname;

    //Поле "Адрес: куда привезти заказ"
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Адрес: куда привезти заказ']")
    private SelenideElement inputAdress;

    //Поле "Станция метро"
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Станция метро']")
    private SelenideElement inputMetro;

    //@FindBy(how = How.CLASS_NAME, using = "select-search")
    @FindBy(how = How.XPATH, using = ".//button/div[@class='Order_Text__2broi'][text()='Лихоборы']")
    private SelenideElement selectMetro;

    //Поле "Телефон"
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Телефон: на него позвонит курьер']")
    private SelenideElement inputPhone;

    //Кнопка "Далее"
    @FindBy(how = How.XPATH, using = ".//button[text()='Далее']")
    private SelenideElement buttonNext;

    //Поле "Когда привезти самокат"
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='* Когда привезти самокат']")
    private SelenideElement inputDateRent;

    //Поле "Срок аренды"
    @FindBy(how = How.CLASS_NAME, using = "Dropdown-placeholder")
    private SelenideElement inputCountDayRent;

    @FindBy(how = How.XPATH, using = ".//div[text()='сутки']")
    private SelenideElement selectCountDayRent;

    //Поле "Цвет самоката" - чекбокс цвет черный
    @FindBy(how = How.ID, using = "black")
    private SelenideElement checkboxBlack;

    //Поле "Цвет самоката" - чекбокс цвет серый
    @FindBy(how = How.ID, using = "grey")
    private SelenideElement checkboxGrey;

    //Поле "Комментарий для курьера"
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='Комментарий для курьера']")
    private SelenideElement inputComment;

    //Кнопка "Заказать" под формой
    @FindBy(how = How.XPATH, using = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']")
    private SelenideElement buttonOrder;

    //Кнопка "Да" подтверждения заказа
    @FindBy(how = How.XPATH, using = ".//button[text()='Да']")
    private SelenideElement buttonYes;

    //Кнопка "Нет" подтверждения заказа
    @FindBy(how = How.XPATH, using = ".//button[text()='Нет']")
    private SelenideElement buttonNo;

    //Модальное окно успешного заказа
    @FindBy(how = How.CLASS_NAME, using = "Order_ModalHeader__3FDaJ")
    private SelenideElement modalOrder;


    //Заполнение данных кириллицей
    public void setInputName(String name) {
        inputName.setValue(name);
    }

    public void setInputSurname(String surname) {
        inputSurname.setValue(surname);
    }

    public void setInputAdress(String streetName) {
        inputAdress.setValue(streetName);
    }

    public void setInputMetro() {
        inputMetro.click();
        selectMetro.click();
    }

    public void setInputPhone(String phoneNumber) {
        inputPhone.setValue(phoneNumber);
    }

    public void clickNextButton() {
        buttonNext.click();
    }

    public void setInputDateRent(String dateRent) {
        inputDateRent.setValue(dateRent).pressEnter();
    }

    public void setInputCountDayRent() {
        inputCountDayRent.click();
        selectCountDayRent.click();
    }

    public void setCheckboxBlack() {
        checkboxBlack.click();
    }

    public void setInputComment(String comment) {
        inputComment.setValue(comment);
    }

    public void clickOrderButton() {
        buttonOrder.click();
    }

    public void clickYesButton() {
        buttonYes.click();
    }

    public String getOrderPlaceStatus() {
        return modalOrder.innerText();
    }

    public void setOrderValue(String name, String surname, String streetName, String phoneNumber, String dateRent,
                                   String comment) {
        setInputName(name);
        setInputSurname(surname);
        setInputAdress(streetName);
        setInputMetro();
        setInputPhone(phoneNumber);
        clickNextButton();
        setInputDateRent(dateRent);
        setInputCountDayRent();
        setCheckboxBlack();
        setInputComment(comment);
        clickOrderButton();
        clickYesButton();
    }

}
