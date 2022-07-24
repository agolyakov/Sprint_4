package ru.yandex.praktikum.pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;

public class HomePage {
    //Логотип яндекс
    @FindBy(how = How.CLASS_NAME, using = "Header_LogoYandex__3TSOI")
    private SelenideElement logoYandex;

    //Логотип самокат
    @FindBy(how = How.CLASS_NAME, using = "Header_LogoScooter__3lsAR")
    private SelenideElement logoSamokat;

    //Кнопки заказать в шапке
    @FindBy(how = How.XPATH, using = ".//button[@class='Button_Button__ra12g']")
    private SelenideElement buttonOrderInHeader;

    //Кнопка заказать в середине страницы
    @FindBy(how = How.XPATH, using = ".//div[@class='Home_FinishButton__1_cWm']/button")
    private SelenideElement buttonOrderInBody;

    //Кнопка статус заказа
    @FindBy(how = How.XPATH, using = ".//button[text()='Статус заказа']")
    private SelenideElement buttonStatusOrder;

    //Список раскрывающихся вопросов
    @FindBy(how = How.ID, using = "accordion__heading-0")
    private SelenideElement question1;

    @FindBy(how = How.ID, using = "accordion__heading-1")
    private SelenideElement question2;

    @FindBy(how = How.ID, using = "accordion__heading-2")
    private SelenideElement question3;

    @FindBy(how = How.ID, using = "accordion__heading-3")
    private SelenideElement question4;

    @FindBy(how = How.ID, using = "accordion__heading-4")
    private SelenideElement question5;

    @FindBy(how = How.ID, using = "accordion__heading-5")
    private SelenideElement question6;

    @FindBy(how = How.ID, using = "accordion__heading-6")
    private SelenideElement question7;

    @FindBy(how = How.ID, using = "accordion__heading-7")
    private SelenideElement question8;

    //Список раскывающихся ответов
    @FindBy(how = How.ID, using = "accordion__panel-0")
    private SelenideElement answer1;

    @FindBy(how = How.ID, using = "accordion__panel-1")
    private SelenideElement answer2;

    @FindBy(how = How.ID, using = "accordion__panel-2")
    private SelenideElement answer3;

    @FindBy(how = How.ID, using = "accordion__panel-3")
    private SelenideElement answer4;

    @FindBy(how = How.ID, using = "accordion__panel-4")
    private SelenideElement answer5;

    @FindBy(how = How.ID, using = "accordion__panel-5")
    private SelenideElement answer6;

    @FindBy(how = How.ID, using = "accordion__panel-6")
    private SelenideElement answer7;

    @FindBy(how = How.ID, using = "accordion__panel-7")
    private SelenideElement answer8;

    @FindBy(how = How.ID, using = "rcc-confirm-button")
    private SelenideElement acceptCookies;

    public void clickAcceptCookies() {
        acceptCookies.click();
    }

    public void clickOrderButtonInHeader() {
        buttonOrderInHeader.click();
    }

    public void clickOrderButtonInBody() {
        buttonOrderInBody.scrollTo().shouldBe(visible).click();
    }

    @FindBy(how = How.CLASS_NAME, using = "Home_Header__iJKdX")
    private SelenideElement headerText;

    //Текст заголовка "Самокат
    //на пару дней"
    public String getHeaderText() {
        return headerText.getOwnText();
    }

    //Текст подзаголовков
    @FindAll(@FindBy(how = How.CLASS_NAME, using = "Home_SubHeader__zwi_E"))
    private ElementsCollection headerSubText;

    //Текст подзаголовка "Привезём его прямо к вашей двери,
    //а когда накатаетесь — заберём"
    public String getHeaderSubText() {
        return headerSubText.get(0).getOwnText();
    }

    //Текст подзаголовка "Он лёгкий и с мощными колёсами— самое то, чтобы ехать по набережной
    // и нежно барабанить пальцами по рулю"
    public String getHeaderSubTextAboutSamokat() {
        return headerSubText.get(1).getOwnText();
    }

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "Home_Column__xlKDK"))
    private ElementsCollection modelSamokat;

    //Возвращает модель самоката
    public String getModelSamokat() {
        return modelSamokat.get(0).getOwnText();
    }

    //Возвращает текст "Максимальная скорость"
    public String getMaxSpeedText() {
        return modelSamokat.get(1).getOwnText();
    }

    //Возвращает значение максимальной скорости
    public String getMaxSpeedValue() {
        return modelSamokat.get(2).getOwnText();
    }

    //Возвращает текст "Проедет без подзарядки"
    public String getRunWithoutChargeText() {
        return modelSamokat.get(3).getOwnText();
    }

    //Возвращает значение езды без подзарядки
    public String getRunWithoutChargeValue() {
        return modelSamokat.get(4).getOwnText();
    }

    //Возвращает текст "Выдерживает вес"
    public String getWithstandsWeightText() {
        return modelSamokat.get(5).getOwnText();
    }

    //Возвращает значение выдерживаемого веса
    public String getWithstandsWeightValue() {
        return modelSamokat.get(6).getOwnText();
    }

    //Блок "Как это работает"
    //Текст подзаголовка "Как это работает"
    public String getHeaderHowItsWorkText() {
        return headerSubText.get(2).getOwnText();
    }

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "Home_Status__YkfmH"))
    private ElementsCollection subHeaderHowItsWork;

    //get(0) - "Заказываете самокат"
    //get(1) - "Курьер привозит самокат"
    //get(2) - "Катаетесь"
    //get(3) - "Курьер забирает самокат"
    public String getSubHeaderHowItsWork() {
        return subHeaderHowItsWork.get(0).getOwnText();
    }

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "Home_StatusDescription__3WGl5"))
    private ElementsCollection subSubHeaderHowItsWork;

    //get(0) - "Выбираете, когда и куда привезти"
    //get(1) - "А вы — оплачиваете аренду"
    //get(2) - "Сколько часов аренды осталось — видно на сайте"
    //get(3) - "Когда аренда заканчивается"
    public String getSubSubHeaderHowItsWork() {
        return subSubHeaderHowItsWork.get(0).getOwnText();
    }

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "Home_StatusCircle__3_aTp"))
    private ElementsCollection stepNumberHowItsWork;

    //get(0) - "1"
    //get(1) - "2"
    //get(2) - "3"
    //get(3) - "4"
    private String getStepNumberHowItsWork() {
        return stepNumberHowItsWork.get(0).getOwnText();
    }

    //Текст подзаголовка "Вопросы о важном"
    public String getHeaderQuestionsAboutImportantText() {
        return headerSubText.get(3).getOwnText();
    }

    //Картинка самоката силуэт
    @FindBy(how = How.XPATH, using = ".//div[@class='Home_BluePrint__TGX2n']/img[@alt='Scooter blueprint']")
    private SelenideElement picSamokatTrafaret;

    //Картинка самоката с текстурой
    @FindBy(how = How.XPATH, using = ".//div[@class='Home_Scooter__3YdJy']/img[@alt='Scooter blueprint']")
    private SelenideElement picSamokat;

    //Массив блоков с вопросами
    @FindAll(@FindBy(how = How.CLASS_NAME, using = "accordion__button"))
    private ElementsCollection question;

    //Массив блоков с ответами
    @FindAll(@FindBy(how = How.CLASS_NAME, using = "accordion__panel"))
    private ElementsCollection answer;

    public String getAnswer(int n) {
        question.get(n).scrollTo().click();
        return answer.get(n).scrollTo().shouldBe(visible).innerText();
    }
}

