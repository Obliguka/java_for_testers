package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class BrowserHelper extends HelperBase{
    public BrowserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void fillFormForUsers(String username, String email) {
        openLoginPage();
        createNewAccount(username,email);
    }

    private void createNewAccount(String username, String email) {
        click(By.cssSelector(".back-to-login-link"));
        type(By.name("username"),username);
        type(By.name("email"),email);
        click(By.cssSelector(".width-40"));
    }

    private void openLoginPage() {
        manager.driver().get("http://localhost/mantisbt-2.26.3/login_page.php");
    }

    public void finalRegistrationUser(String username, String password, String url) {
        openLink(url);
        fillFields(username, password);

    }

    private void fillFields(String username, String password) {
        type(By.cssSelector("#password"),password);
        type(By.cssSelector("#password-confirm"),password);
        click(By.cssSelector(".width-100"));
    }

    private void openLink(String url) {
        manager.driver().get(url);
    }
}
