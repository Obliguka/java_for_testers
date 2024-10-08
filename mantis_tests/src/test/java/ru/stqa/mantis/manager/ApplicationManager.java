package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    private String browser;
    private String string;
    private Properties properties;
    private SessionHelper sessionHelper;
    private HttpSessionHelper httpSessionHelper;
    private ru.stqa.mantis.manager.JamesCliHelper JamesCliHelper;
    private ru.stqa.mantis.manager.MailHelper MailHelper;
    private ru.stqa.mantis.manager.BrowserHelper BrowserHelper;
    private ru.stqa.mantis.manager.JamesApiHelper JamesApiHelper;
    private ru.stqa.mantis.manager.DeveloperMailHelper DeveloperMailHelper;
    private ru.stqa.mantis.manager.RestApiHelper RestApiHelper;

    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties=properties;

    }

    public WebDriver driver(){
        if (driver==null){
            if ("chrome".equals(string))
            {
                driver = new ChromeDriver();
            }
            else if ("firefox".equals(string))
            {
                driver = new FirefoxDriver();
            }
            else
            {
                throw new IllegalArgumentException(String.format("Unknown browser %s", string));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1552, 840));
        }
        return driver;
    }

    public SessionHelper session(){
        if(sessionHelper==null){
            sessionHelper=new SessionHelper(this);
        }
        return sessionHelper;

    }

    public HttpSessionHelper http() {
        if(httpSessionHelper==null){
            httpSessionHelper=new HttpSessionHelper(this);
        }
        return httpSessionHelper;
    }

    public JamesCliHelper jamesCli() {
        if(JamesCliHelper==null){
            JamesCliHelper=new JamesCliHelper(this);
        }
        return JamesCliHelper;
    }

    public JamesApiHelper jamesApi() {
        if(JamesApiHelper==null){
            JamesApiHelper=new JamesApiHelper(this);
        }
        return JamesApiHelper;
    }

    public DeveloperMailHelper developerMail() {
        if(DeveloperMailHelper==null){
            DeveloperMailHelper=new DeveloperMailHelper(this);
        }
        return DeveloperMailHelper;
    }

    public MailHelper mail() {
        if(MailHelper==null){
            MailHelper=new MailHelper(this);
        }
        return MailHelper;
    }

    public BrowserHelper browser() {
        if(BrowserHelper==null){
            BrowserHelper=new BrowserHelper(this);
        }
        return BrowserHelper;
    }

    public String property(String name){
        return properties.getProperty(name);

    }

    public RestApiHelper rest() {
        if(RestApiHelper==null){
            RestApiHelper=new RestApiHelper(this);
        }
        return RestApiHelper;
    }
}
