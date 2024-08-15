package manage;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase{
    public ContactHelper(ApplicationManager manager)
    {
        super(manager);
    }

    public void createdContact(ContactData contact) {
        openContactsPage();
        fillContactsForm();
        submitContactCreation();
        returnToContactsPage();
    }

    private void returnToContactsPage() {
        manager.driver.findElement(By.linkText("home page")).click();
    }

    private void submitContactCreation() {
        manager.driver.findElement(By.name("submit")).click();
    }

    private void fillContactsForm() {
        //manager.driver.findElement(By.name("theform")).click();
        type(By.name("firstname"),"Mary");
        type(By.name("middlename"),"Gig");
        type(By.name("lastname"),"Nnn");
        type(By.name("nickname"),"Mary_12");
        type(By.name("address"),"Voronezh, Svobody street, 96");
        type(By.name("home"),"9090");
        type(By.name("mobile"),"8974765345");
        type(By.name("work"),"00888");
        type(By.name("email"),"mary.g@kk.com");
        //driver.findElement(By.name("new_group")).click();
    }

    private void openContactsPage() {
        manager.driver.findElement(By.linkText("add new")).click();
    }
}
