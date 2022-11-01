import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class TestDropdown {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new EdgeDriver();
    //WebDriver driver = new FirefoxDriver();
    private final String textQuest1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String textQuest2 = "Пока что у нас так: один заказ — один самокат. " +
            "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String textQuest3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
            " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
            " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String textQuest4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String textQuest5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String textQuest6 = "Самокат приезжает к вам с полной зарядкой. " +
            "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String textQuest7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String textQuest8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";



    @Before //перед каждым тестом открываем страницу и скроллим её до элементов + ждём пока они прогрузятся
    public void checkTextSamocat() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Object elementQuestions = driver.findElement(By.xpath("//div[@class='Home_FourPart__1uthg']/div[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementQuestions);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-0")));
    }

    @Test  //проверяем текст с первой кнопке
    public void checkTextSamocatText0() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest1, objTextButton.dropdownListBut0());
    }
    @Test //проверяем текст во второй кнопке
    public void checkTextSamocatText1() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest2, objTextButton.dropdownListBut1());
    }
    @Test  //проверяем текст в третьей кнопке
    public void checkTextSamocatText2() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest3, objTextButton.dropdownListBut2());
    }
    @Test  //проверяем текст в четвертой кнопке
    public void checkTextSamocatText3() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest4, objTextButton.dropdownListBut3());
    }
    @Test  //проверяем текст в пятой кнопке
    public void checkTextSamocatText4() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest5, objTextButton.dropdownListBut4());
    }
    @Test  //проверяем текст в шестой кнопке
    public void checkTextSamocatText5() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest6, objTextButton.dropdownListBut5());
    }
    @Test  //проверяем текст в седьмой кнопке
    public void checkTextSamocatText6() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest7, objTextButton.dropdownListBut6());
    }
    @Test  //проверяем текст в восьмой кнопке
    public void checkTextSamocatText7() {
        TextDropdown objTextButton = new TextDropdown(driver);
        assertEquals("Not correct text",textQuest8, objTextButton.dropdownListBut7());
    }

    @After
    public void checkTextClose () {
        driver.quit();
    }
}