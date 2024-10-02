package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.IssueData;

public class IssueCreationTests extends TestBase{
    @Test
    void canCreationIssue(){
        app.rest().createIssue(new IssueData()
                .withSummery(CommonFunctions.randomString(10))
                .withDescription(CommonFunctions.randomString(50))
                .withProject(1L));

    }
}
