import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupCreatingTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1552, 840));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.xpath("//form[@id=\'LoginForm\']/input[3]")).click();
        }
    }

  /*  @AfterEach
    public void tearDown() {
        //driver.findElement(By.linkText("Logout")).click();
        //driver.quit();
    }*/

    @Test
    public void canCreatedGroup() {
        if (! isElementPresent(By.name("new"))) {

            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("group_name");
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys("group_header");
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys("group_footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();

    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        }catch (NoSuchElementException exception){
            return false;
        }
    }

    @Test
    public void canCreatedGroupWithEmptyName() {

        if (! isElementPresent(By.name("new"))) {

            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("");
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys("");
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys("");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("group page")).click();
    }
}
