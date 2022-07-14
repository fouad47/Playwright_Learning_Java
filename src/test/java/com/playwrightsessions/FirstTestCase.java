package com.playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

import java.nio.file.Paths;

public class FirstTestCase {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeTest
    public void setUp()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
    }

    @Test
    public void verifyFirstProgram()
    {
        page.navigate("https://playwright.dev/");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        String title = page.title();
        System.out.println("Page title is: "+title);

        String url = page.url();
        System.out.println("Page URL is: "+ url);

        assertEquals(title, page.title());
    }

    @AfterTest
    public void tearDown(){
        browser.close();
        playwright.close();
    }
}
