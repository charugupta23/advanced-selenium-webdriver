package com.herokuapp.theinternet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser, org.apache.logging.log4j.Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver createDriver(){
        log.info("create driver: " + browser);

    switch (browser){
        case "chrome":
           /* System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/chromedriver");*/
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            //driver = new ChromeDriver(options);
            driver.set(new ChromeDriver(options));
            break;
        case "firefox":
            System.setProperty("webdriver.gecko.driver",
                    "src/main/resources/geckodriver");
            driver.set(new FirefoxDriver());
            break;
        default:
            System.out.println("Do not know how to start: " + browser + ", starting Chrome." );
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver.set(new ChromeDriver());
            break;
        }
        return driver.get();
    }
}
