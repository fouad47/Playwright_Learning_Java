package ibex.assignment1;

// mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://demoqa.com/"

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.text.html.Option;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Tutorial {

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
        page.navigate("https://demoqa.com/");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        //Locator 1
        Locator l1 = page.locator("//img[@src='/images/Toolsqa.jpg']");
        l1.hover();
        l1.click();
        System.out.println("Locator 1 Clicked");

        //Assert 1
        String title = page.title();
        System.out.println("Page title is: "+title);
        Assert.assertEquals(title, "ToolsQA");
        System.out.println("Assert 1 done");

        //assert 2
        assertThat(page.locator("//img[@src='/images/Toolsqa.jpg']")).isVisible();
        System.out.println("Assert 2 done");

        // assert 3
        String url = page.url();
        System.out.println("Page URL is: "+ url);
        Assert.assertEquals(url, "https://demoqa.com/");
        System.out.println("Assert 3 done");

        // locator 2 click on element button to redirect element page
        Locator l2 = page.locator("//*[name()='path' and contains(@d,'M16 132h41')]");
        l2.click();
        System.out.println("Locator 2 Clicked");

        page.waitForLoadState(LoadState.NETWORKIDLE);
        System.out.println("Redirected to element page");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example1.png")));

        //Assert 4
        String title1 = page.title();
        System.out.println("Page title is: "+title1);
        Assert.assertEquals(title1, "ToolsQA");
        System.out.println("Assert 4 done");

        //assert 5
        assertThat(page.locator("//img[@src='/images/Toolsqa.jpg']")).isVisible();
        System.out.println("Assert 5 done");

        // assert 6
        String url1 = page.url();
        System.out.println("Page URL is: "+ url1);
        Assert.assertEquals(url1, "https://demoqa.com/elements");
        System.out.println("Assert 6 done");

        // locator 3 click on element button to redirect element page
        Locator l3 = page.locator("//span[normalize-space()='Check Box']");
        l3.click();
        System.out.println("Locator 3 Clicked");


        //Checkboxes
        assertThat(page.locator("//span[@class='rct-checkbox']//*[name()='svg']")).isEnabled();
        System.out.println("Checkbox is enabled");
        //assertThat(page.locator("//span[@class='rct-checkbox']//*[name()='svg']")).isChecked();
        assertThat(page.locator("//span[@class='rct-checkbox']//*[name()='svg']")).not().isChecked();
        System.out.println("Checkbox is not checked");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example2.png")));

    }

    @AfterTest
    public void tearDown(){
        browser.close();
        playwright.close();
    }
}
