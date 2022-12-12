import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class TextDropdown {

    private WebDriver driver;

    // URL главной страницы
    private String url = "https://qa-scooter.praktikum-services.ru/";
    private By howMuchCostAndHowToPay = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    private By textHowMuchCostAndHowToPay = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By wantSomeScooters = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    private By textWantSomeScooters = By.xpath(".//div[@id='accordion__panel-1']/p");
    private By howCalculatedTimeIsRental = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    private By textHowCalculatedTimeIsRental = By.xpath(".//div[@id='accordion__panel-2']/p");
    private By isPossibleToOrderScooterToday = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    private By textIsPossibleToOrderScooterToday = By.xpath(".//div[@id='accordion__panel-3']/p");
    private By isPossibleExtendOrderOrReturnScooterEarlier = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    private By textIsPossibleExtendOrderOrReturnScooterEarlie = By.xpath(".//div[@id='accordion__panel-4']/p");
    private By youBringChargingFlongWithScooter = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    private By textYouBringChargingFlongWithScooter = By.xpath(".//div[@id='accordion__panel-5']/p");
    private By isPossibleCancelOrder = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    private By textIsPossibleCancelOrder = By.xpath(".//div[@id='accordion__panel-6']/p");
    private By liveBehindMkadWillYouBringMe = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    private By textLiveBehindMkadWillYouBringMe = By.xpath(".//div[@id='accordion__panel-7']/p");

    public TextDropdown(WebDriver driver) {
        this.driver = driver;
    }

    public void openScooterPage() {
        driver.get(url);
    }

    public void clickQuest(int numberQuest) {
        if (numberQuest == 1) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(howMuchCostAndHowToPay));
            driver.findElement(howMuchCostAndHowToPay).click();
        } else if (numberQuest  == 2) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(wantSomeScooters));
            driver.findElement(wantSomeScooters).click();
        } else if (numberQuest  == 3) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(howCalculatedTimeIsRental));
            driver.findElement(howCalculatedTimeIsRental).click();
        } else if (numberQuest  == 4) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(isPossibleToOrderScooterToday));
            driver.findElement(isPossibleToOrderScooterToday).click();
        } else if (numberQuest  == 5) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(isPossibleExtendOrderOrReturnScooterEarlier));
            driver.findElement(isPossibleExtendOrderOrReturnScooterEarlier).click();
        } else if (numberQuest  == 6) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(youBringChargingFlongWithScooter));
            driver.findElement(youBringChargingFlongWithScooter).click();
        } else if (numberQuest  == 7) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(isPossibleCancelOrder));
            driver.findElement(isPossibleCancelOrder).click();
        } else if (numberQuest  == 8) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(liveBehindMkadWillYouBringMe));
            driver.findElement(liveBehindMkadWillYouBringMe).click();
        }
    }

    public void checkAnswerQuest(int numberQuest, String answer) {
        if (numberQuest == 1) {
            String getText = driver.findElement(textHowMuchCostAndHowToPay).getText();
            assertEquals(answer, getText);
        } else if (numberQuest == 2) {
            String getText = driver.findElement(textWantSomeScooters).getText();
            assertEquals(answer, getText);
        } else if (numberQuest == 3) {
            String getText = driver.findElement(textHowCalculatedTimeIsRental).getText();
            assertEquals(answer, getText);
        } else if (numberQuest == 4) {
            String getText = driver.findElement(textIsPossibleToOrderScooterToday).getText();
            assertEquals(answer, getText);
        } else if (numberQuest == 5) {
            String getText = driver.findElement(textIsPossibleExtendOrderOrReturnScooterEarlie).getText();
            assertEquals(answer, getText);
        } else if (numberQuest == 6) {
            String getText = driver.findElement(textYouBringChargingFlongWithScooter).getText();
            assertEquals(answer, getText);
        } else if (numberQuest == 7) {
            String getText = driver.findElement(textIsPossibleCancelOrder).getText();
            assertEquals(answer, getText);
        } else if (numberQuest == 8) {
            String getText = driver.findElement(textLiveBehindMkadWillYouBringMe).getText();
            assertEquals(answer, getText);
        }
    }
}