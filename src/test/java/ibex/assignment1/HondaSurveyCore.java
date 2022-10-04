package ibex.assignment1;

/*

mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen http://www.londonfreelance.org/courses/frames/index.html
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://hs-uat.reflecx.io/responses/survey/VnH%252FZPQebv1VJmDWYdO21Dn19q0CaY56myYXAzk3OZRMXXgQ41DJVeMMj9aDZeq%252BdX%252BpKJp8Y1Js6RK4n2ZOKG0QkJM81ioO0D%252FHc8xWclryetllRaf3MKc7B5ZqTTOtayv7w%252BfmZtRAtNsOoBArCLBRQssr3fGqc1Pg0hF%252BeJw%253D?channel=email

*/

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.nio.file.Paths;

public class HondaSurveyCore {

    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeTest
    public void setUp()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
        page.setDefaultTimeout(60000);
    }

    @Test (priority = 1)
    public void verifyLoginToDashboard() {
        // Go to https://hs-uat.reflecx.io/responses/survey/iu1BmsELUON5mErs7F6ZtWiM1IUP%252Bj3oc9XCWFQ4DhQ%252BbdnH9wyGj0Az8penZ4au29goyotV6X57vhFLol3yHnmXQAa9xcsSXSHkhiMjX6MmYTMPnOqtglVahHkRiSBRWzxMO2Qjv2E4vO4Gpn6jfbuS11LXJy36HvcfsZiG5vM%253D?channel=email
        page.navigate("https://hs-uat.reflecx.io/responses/survey/Flg9g2la5nOHC5WJk73m73GRimoVFF63HbI%252FgyvfBAazDTpdD1zfFqU9NGNPs9GMH5ZJ97Uq%252BElDVQ4X10T4surAMrDKc7ZkxEP8kp3ifNxBAJ98xa5nkJT1TOUSRb24W35A4MdLCIm3MuEhoipq%252F8pWBUFrdgd6zhwAEqIZRDM%253D?channel=email");
        // Click label:has-text("Yes")
        page.locator("label:has-text(\"Yes\")").click();
        // Wait for the page to load
        page.waitForLoadState(LoadState.NETWORKIDLE);
        // Click text=Repair You Paid For
        page.locator("text=Repair You Paid For").click();
        // Click label:has-text("Yes, I used this service") >> nth=0
        page.locator("label:has-text(\"Yes, I used this service\")").first().click();
        // Click label:has-text("No, I did not use this service") >> nth=1
        page.locator("label:has-text(\"No, I did not use this service\")").nth(1).click();
        // Click label:has-text("No, I did not use this service") >> nth=2
        page.locator("label:has-text(\"No, I did not use this service\")").nth(2).click();
        // Click label:has-text("No, I did not use this service") >> nth=3
        page.locator("label:has-text(\"No, I did not use this service\")").nth(3).click();
        // Click [id="\36 141d921711acc92a873a894"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content
        page.locator("[id=\"\\36 141d921711acc92a873a894\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content").click();
        // Click [id="\36 141d98a711acc92a873a9d5"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content
        page.locator("[id=\"\\36 141d98a711acc92a873a9d5\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content").click();
        // Click [id="\36 141d9aa711acc92a873aa34"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content
        page.locator("[id=\"\\36 141d9aa711acc92a873aa34\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content").click();
        // Click [id="\36 141da29711acc92a873abf7"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content
        page.locator("[id=\"\\36 141da29711acc92a873abf7\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content").click();
        // Click [id="\36 141dc2b711acc92a873b4fe"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content
        page.locator("[id=\"\\36 141dc2b711acc92a873b4fe\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content").click();
        // Click [id="\36 141dbf4711acc92a873b3c5"] > .question__answer > .rating-scale > li:nth-child(2) > .scale__label
        page.locator("[id=\"\\36 141dbf4711acc92a873b3c5\"] > .question__answer > .rating-scale > li:nth-child(2) > .scale__label").click();
        // Click [id="\36 141dd40711acc92a873be80"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label
        page.locator("[id=\"\\36 141dd40711acc92a873be80\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label").click();
        // Click [id="\36 141de14711acc92a873c9b9"] > .question__answer > .rating-scale > li:nth-child(2) > .scale__label
        page.locator("[id=\"\\36 141de14711acc92a873c9b9\"] > .question__answer > .rating-scale > li:nth-child(2) > .scale__label").click();
        // Click [id="\36 141de81711acc92a873cae5"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label
        page.locator("[id=\"\\36 141de81711acc92a873cae5\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label").click();
        // Click [id="\36 141dee5711acc92a873ccab"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label
        page.locator("[id=\"\\36 141dee5711acc92a873ccab\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label").click();
        // Click [id="\36 141df26711acc92a873cdae"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content
        page.locator("[id=\"\\36 141df26711acc92a873cdae\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label > .inline-content").click();
        // Click [id="\36 141df3a711acc92a873ce21"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label
        page.locator("[id=\"\\36 141df3a711acc92a873ce21\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label").click();
        // Click [id="\36 141df5a711acc92a873cee0"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label
        page.locator("[id=\"\\36 141df5a711acc92a873cee0\"] > .question__answer > .rating-scale > li:nth-child(5) > .scale__label").click();
        // Click text=No, Service Advisor didn't offer/explain
        page.locator("text=No, Service Advisor didn't offer/explain").click();
        // Click text=Was your Honda ready when promised? * Yes No Add Comment >> span >> nth=2
        page.locator("text=Was your Honda ready when promised? * Yes No Add Comment >> span").nth(2).click();
        // Click label:has-text("5-10 minutes")
        page.locator("label:has-text(\"5-10 minutes\")").click();
        // Click [id="\36 141e0d0711acc92a873da1b"] > .question__answer > .rating-scale > li:nth-child(2) > .scale__label
        page.locator("[id=\"\\36 141e0d0711acc92a873da1b\"] > .question__answer > .rating-scale > li:nth-child(2) > .scale__label").click();
        // Click textarea[name="option\.Id"] >> nth=0
        page.locator("textarea[name=\"option\\.Id\"]").first().click();
        // Fill textarea[name="option\.Id"] >> nth=0
        page.locator("textarea[name=\"option\\.Id\"]").first().fill("tttt");
        // Click [id="\36 141e18f711acc92a873df04"] > .question__answer > .rating-scale > li:nth-child(6) > .scale__label
        page.locator("[id=\"\\36 141e18f711acc92a873df04\"] > .question__answer > .rating-scale > li:nth-child(6) > .scale__label").click();
        // Click text=Is it fixed now? * Yes No Add Comment >> label >> nth=1
        page.locator("text=Is it fixed now? * Yes No Add Comment >> label").nth(1).click();
        // Click text=Did not return to dealer, fixed vehicle myself
        page.locator("text=Did not return to dealer, fixed vehicle myself").click();
        // Click text=Repair attempt did not fix problem/technician error
        page.locator("text=Repair attempt did not fix problem/technician error").click();
        // Click text=Yes, by text
        page.locator("text=Yes, by text").click();
        // Click text=Yes No Don’t know >> label >> nth=1
        page.locator("text=Yes No Don’t know >> label").nth(1).click();
        // Click text=Excellent Very Good Good Fair Poor Add Comment >> label >> nth=3
        page.locator("text=Excellent Very Good Good Fair Poor Add Comment >> label").nth(3).click();
        // Click text=Excellent Very Good Good Fair Poor Add Comment >> label >> nth=3
        page.locator("text=Excellent Very Good Good Fair Poor Add Comment >> label").nth(3).click();
        // Click text=Excellent Very Good Good Fair Poor Add Comment >> label >> nth=2
        page.locator("text=Excellent Very Good Good Fair Poor Add Comment >> label").nth(2).click();
        // Click .rating__label >> nth=0
        page.locator(".rating__label").first().click();
        // Click [id="\36 141ef48711acc92a87443a2"] > .question__answer > .rating-list-container > .main-rating > .rating-list > li > .rating__label >> nth=0
        page.locator("[id=\"\\36 141ef48711acc92a87443a2\"] > .question__answer > .rating-list-container > .main-rating > .rating-list > li > .rating__label").first().click();
        // Click label:has-text("Female")
        page.locator("label:has-text(\"Female\")").click();
        // Click label:has-text("30-34")
        page.locator("label:has-text(\"30-34\")").click();
        // Click text=Submit
        page.locator("text=Submit").click();
        assertThat(page).hasURL("https://hs-uat.reflecx.io/responses/thankyou/VnH%252FZPQebv1VJmDWYdO21Dn19q0CaY56myYXAzk3OZRMXXgQ41DJVeMMj9aDZeq%252BdX%252BpKJp8Y1Js6RK4n2ZOKG0QkJM81ioO0D%252FHc8xWclryetllRaf3MKc7B5ZqTTOtayv7w%252BfmZtRAtNsOoBArCLBRQssr3fGqc1Pg0hF%252BeJw%253D?channel=email&ss=false");



    }


    @AfterTest
    public void tearDown(){
        browser.close();
        playwright.close();
    }

}
