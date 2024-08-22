package manage;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager)
    {
        super(manager);
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new")))
        {

            click(By.linkText("groups"));
        }
    }
    

    public void createdGroup(GroupData group)
    {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }
    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupPage();
    }
    public void modifyGroup(GroupData group)
    {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupPage();

    }
    private void removeSelectedGroup()
    {
        click(By.name("delete"));
    }


    private void submitGroupCreation()
    {
        click(By.name("submit"));
    }


    private void initGroupCreation()
    {
        click(By.name("new"));
    }


    private void fillGroupForm(GroupData group)
    {
        type(By.name("group_name"),group.name());
        type(By.name("group_header"),group.header());
        type(By.name("group_footer"),group.footer());
    }

    private void returnToGroupPage()
    {
        click(By.linkText("group page"));
    }

    private void submitGroupModification()
    {
        click(By.name("update"));
    }

    private void initGroupModification()
    {
        click(By.name("edit"));
    }

    private void selectGroup()
    {
        click(By.name("selected[]"));
    }

    public int getCount() {
        openGroupsPage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
