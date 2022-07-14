package ibex.assignment1;

// mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://qacx.reflecx.io

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.testng.AssertJUnit.assertEquals;

public class Assignment1 {

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
    public void verifyFirstIbexProgram()
    {
        // Go to https://qacx.reflecx.io/accounts/Account/Login
        page.navigate("https://qacx.reflecx.io");
        // Assert page title
        String actualTitle = page.title();
        System.out.println("Login Page title is: "+actualTitle);
        Assert.assertEquals(actualTitle, "Reflecx");
        // Take Screenshot of the current page
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        page.click("input[name=\"Username\"]");
        // Fill input[name="Username"]
        page.fill("input[name=\"Username\"]", "admin.smithville");
        // Click input[name="Password"]
        page.click("input[name=\"Password\"]");
        // Fill input[name="Password"]
        page.fill("input[name=\"Password\"]", "u4bhrRcw6VjabUda");
        // Click button:has-text("Sign in")
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://qacx.reflecx.io/portal/insights/dashboard"), () ->
        page.waitForNavigation(() -> {
            page.click("button:has-text(\"Sign in\")");
        });
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // Assert page title
        String actualTitle1 = page.title();
        System.out.println("Dashboard Page title is: "+actualTitle1);
        Assert.assertEquals(actualTitle1, "Reflecx | Dashboard");
        // Assert page URL
        String pageUrl1 = page.url();
        System.out.println("Dashboard Page URL is: "+ pageUrl1);
        Assert.assertEquals(pageUrl1, "https://qacx.reflecx.io/portal/insights/dashboard");
        // Take screenshot of the current page
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example2.png")));
        // Click Total Alerts widget
         page.waitForNavigation(() -> {
            page.click("text=Edit Total Alerts Created with Highcharts 9.3.3KPI 0% Alert Count 0 0 0.0 % New  >> i");
        });
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // Click h1:has-text("Alert List")
        page.click("h1:has-text(\"Alert List\")");
        // Assert page title
        String actualTitle2 = page.title();
        System.out.println("Alert Page title is: "+actualTitle2);
        Assert.assertEquals(actualTitle2, "Reflecx | Alert List");
        // Assert page URL
        String pageUrl2 = page.url();
        System.out.println("Alert Page URL is: "+ pageUrl2);
        Assert.assertEquals(pageUrl2, "https://qacx.reflecx.io/portal/insights/alerts/list");
        // Take screenshot of the current page
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example3.png")));

        // Click .user-dropdown-link
        page.click(".user-dropdown-link");
        // Click text=Logout
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("https://qacx.reflecx.io/accounts/Account/Login?ReturnUrl=%2Faccounts%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dlocal-angular%26redirect_uri%3Dhttps%253A%252F%252Fqacx.reflecx.io%252Fportal%252Fsignin-callback%26response_type%3Dcode%26scope%3Dopenid%2520profile%2520email%2520api1%2520offline_access%26state%3D6de377f0711b44d9a124e7dc6947f4b9%26code_challenge%3D7sOoGzRm16G9H9K1tOJgo3ZQ05bTDalBwcdx6JZntTU%26code_challenge_method%3DS256%26response_mode%3Dquery"), () ->
        page.waitForNavigation(() -> {
            page.click("text=Logout");
        });
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // Assert the current page
        System.out.println("Logout Page title is: "+actualTitle);
        Assert.assertEquals(actualTitle, "Reflecx");
        // Take screenshot of the current page
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example4.png")));
    }

    @AfterTest
    public void tearDown(){
        browser.close();
        playwright.close();
    }

}
