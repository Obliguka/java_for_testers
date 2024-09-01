package manage;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase{
    public ContactHelper(ApplicationManager manager)
    {
        super(manager);
    }

    public void createdContact(ContactData contact) {
        openNewContactsPage();
        fillContactsForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }

    public void removalContact() {
        openContactsPage();
        selectContact();
        submitRemovalContact();
    }

    private void openContactsPage()
    {
        click(By.linkText("home"));
    }

    private void submitRemovalContact()
    {
        click(By.cssSelector(".left:nth-child(8) > input"));
    }

    private void selectContact()
    {
        click(By.name("selected[]"));
    }

    private void returnToContactsPage()
    {
        click(By.linkText("home page"));
    }

    private void submitContactCreation()
    {
        click(By.name("submit"));
    }

    private void fillContactsForm(ContactData contact)
    {
        type(By.name("firstname"),contact.firstname());
        type(By.name("middlename"),contact.middlename());
        type(By.name("lastname"),contact.lastname());
        type(By.name("nickname"),contact.nickname());
        type(By.name("address"),contact.address());
        type(By.name("home"),contact.home());
        type(By.name("mobile"),contact.mobile());
        type(By.name("work"),contact.work());
        type(By.name("email"),contact.email());
    }

    private void openNewContactsPage()
    {
        click(By.linkText("add new"));
    }

    public boolean isContactPresent()
    {
        openContactsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public int getCount() {
        openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
