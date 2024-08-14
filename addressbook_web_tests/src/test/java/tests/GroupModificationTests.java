package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase{

    @Test
    void TestModifyGroup()
    {
        if (!TestBase.app.groups().isGroupPresent()){
            TestBase.app.groups().createdGroup(new GroupData("", "", ""));
        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }

}