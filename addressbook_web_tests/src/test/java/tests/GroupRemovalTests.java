package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {

    @Test
    public void canRemoveGroup() {

        if (app.groups().getCount()==0){
            app.groups().createdGroup(new GroupData("", "", "", ""));
        }
        int groupCount=app.groups().getCount();
        var oldGroups=app.groups().getList();
        var rnd=new Random();
        var index=rnd.nextInt(oldGroups.size());

        app.groups().removeGroup(oldGroups.get(index));
        var newGroups=app.groups().getList();
        var expectedList=new ArrayList<>(oldGroups);
        expectedList.remove(index);

        int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(newGroups,expectedList);
    }

    @Test
    void canRemovalAllGroupsAtOnce(){
        if (app.groups().getCount()==0){
            app.groups().createdGroup(new GroupData("", "", "", ""));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.groups().getCount());

    }

    @Test
    public void canRemoveGroupFromDB() {

        if (app.hbm().getGroupCount()==0){
            app.hbm().createdGroup(new GroupData("", "", "", ""));
        }
        //int groupCount=app.groups().getCount();
        var oldGroups=app.hbm().getGroupList();
        var rnd=new Random();
        var index=rnd.nextInt(oldGroups.size());

        app.groups().removeGroup(oldGroups.get(index));
        var newGroups=app.hbm().getGroupList();
        var expectedList=new ArrayList<>(oldGroups);
        expectedList.remove(index);

        //int newGroupCount=app.groups().getCount();
        Assertions.assertEquals(newGroups,expectedList);
    }

    @Test
    void canRemovalAllGroupsAtOnceFromDB(){
        if (app.hbm().getGroupCount()==0){
            app.hbm().createdGroup(new GroupData("", "", "", ""));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0,app.hbm().getGroupCount());

    }


}
