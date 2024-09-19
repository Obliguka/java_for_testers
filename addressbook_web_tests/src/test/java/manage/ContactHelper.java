package manage;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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

    public void create(ContactData contact, GroupData group) {
        openNewContactsPage();
        fillContactsForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToContactsPage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    public void createdContactWithoutPhoto(ContactData contact) {
        openNewContactsPage();
        fillContactsWithoutPhotoForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }

    public void removalContact(ContactData contact) {
        //openContactsPage();
        selectContact(contact);
        submitRemovalContact();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[id='%s']", contact.id())));
    }

    private void openContactsPage()
    {
        click(By.linkText("home"));
    }

    private void submitRemovalContact()
    {
        click(By.cssSelector(".left:nth-child(8) > input"));
    }

    private void selectForModificationContact(ContactData contact)
    {

       // click(By.name("selected[]"));
        click(By.cssSelector(String.format("[href=\"edit.php?id=%s\"]", contact.id())));//"input[id='%s']", contact.id())));
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
        attach(By.name("photo"), contact.photo());
    }
    private void fillContactsWithoutPhotoForm(ContactData contact)
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
        //attach(By.name("photo"), contact.photo());
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
        //openContactsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void removeAllContacts() {
        openContactsPage();
        selectAllContacts();
        removeSelectedContact();

    }
    private void removeSelectedContact()
    {
        click(By.cssSelector("input[value=\"Delete\"]"));
    }
    private void selectAllContacts() {
        var checkboxes=manager.driver.findElements(By.name("selected[]"));

        for (var checkbox : checkboxes)
        {
            checkbox.click();
        }
    }

    public List<ContactData> getList() {
        openContactsPage();
        var contacts=new ArrayList<ContactData>();
        var centers=manager.driver.findElements(By.cssSelector("tr[name=\"entry\"]")); //"td.center input"));
        for (var cen : centers){
            var lastName=cen.findElement(By.cssSelector("td:nth-child(2)"));//считываем lastname
            var lastN=lastName.getText();
            if (lastN == null || lastN.isEmpty()) {
                lastN="";
            }
            var firstName=cen.findElement(By.cssSelector("td:nth-child(3)"));//считываем firstname
            var firstN=firstName.getText();
            if (firstN == null || firstN.isEmpty()) {
                firstN="";
            }
            var address=cen.findElement(By.cssSelector("td:nth-child(4)"));//считываем address
            var addressN=address.getText();
            if (addressN == null || addressN.isEmpty()) {
                addressN="";
            }


            var checkbox=cen.findElement(By.name("selected[]"));
            var id=checkbox.getAttribute("id");

            contacts.add(new ContactData().withId(id).withLastName(lastN).withFirstName(firstN).withAddress(addressN));
        }


        return contacts;

    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {

        openContactsPage();
        selectForModificationContact(contact);
        //initContactModification();
        //fillContactsForm(modifiedContact);
        fillContactsWithoutPhotoForm(modifiedContact);
        submitContactModification();
        //returnToContactPage();
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification() {
        click(By.cssSelector("td.center [title=\"Edit\"]"));
    }

    public void removeInGroup(ContactData contact, GroupData group) {

    }
}
