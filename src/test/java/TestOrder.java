import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.cssSelector;

@RunWith(Parameterized.class)
public class TestOrder {

    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new EdgeDriver();
    //WebDriver driver = new FirefoxDriver();

    final By buttonAddress;
    final String name;
    final String secondName;
    final String address;
    final String number;
    final String comment;

    public TestOrder(By buttonAddress, String name, String secondName, String address, String number, String comment) {
        this.buttonAddress = buttonAddress;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.number = number;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getPage() {
        return new Object[][] {
                {cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g"), "Павел", "Андрушко", "Ленина 7", "89196758797", "Просьба позвонить"},
                {cssSelector("div.Home_RoadMap__2tal_ > div.Home_FinishButton__1_cWm > button"), "Андрей", "Клинов", "Москва", "89438875432", "Встреча у входа в подъезд"},
        };
    }

    @Test
    public void checkOrderFromHeader_success() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        TextOrder objFirstFormPage = new TextOrder(driver);
        objFirstFormPage.startPage();
        objFirstFormPage.findCheckAndClickOrderButton(buttonAddress);
        objFirstFormPage.userName(name);
        objFirstFormPage.userSurname(secondName);
        objFirstFormPage.userAddress(address);
        objFirstFormPage.userPhone(number);
        objFirstFormPage.metroStation();
        objFirstFormPage.metroStationChoice();
        objFirstFormPage.nextPageButton();
        objFirstFormPage.calendarDate();
        objFirstFormPage.rentalDuration();
        objFirstFormPage.scooterColour();
        objFirstFormPage.userComment(comment);
        objFirstFormPage.orderButton();
        objFirstFormPage.confirmButton();
        assertTrue("An error occurred while checking", objFirstFormPage.isOrderCreated());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
