package com.playwrightsessions;



import com.microsoft.playwright.*;
import java.nio.file.Paths;
import com.naveenplaywrightlearn.tests.HomePageTests;

public class PlaywrightFirstTest {

    public static void main(String[] args){

        HomePageTests naveen = new HomePageTests();
        naveen.homePageTitleTest();
        naveen.homePageURLTest();





//        Playwright playwright = Playwright.create();
//
//        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
//        Page page = browser.newPage();
//        page.navigate("http://whatsmyuseragent.org/");
//
//        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//
//        String title = page.title();
//        System.out.println("Page title is: "+title);
//
//        String url = page.url();
//        System.out.println("Page URL is: "+ url);
//
//        browser.close();
//        playwright.close();
    }
}
