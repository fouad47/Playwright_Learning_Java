package com.pramodplaywrightlearn.pages;

import com.microsoft.playwright.Page;

public class LoginVWOPage {

    private final Page page;

    public LoginVWOPage(Page page) {
        this.page = page;
    }

    String userName = "#login-username";
    String passWord = "#login-password";
    String submitButton = "#js-login-btn";
    String welcomeProfileButton = "[data-qa='lufexuloga']";

    public void setUserName(String userNamePass){
        page.fill(userName, userNamePass);
    }
    public void setPassWord(String passWordPass){
        page.fill(passWord, passWordPass);
    }
    public boolean Login(String usr, String pwd){
        boolean isLoginSuccess = false;

        setUserName(usr);;
        setPassWord(pwd);

        page.click(submitButton);
        page.waitForSelector(welcomeProfileButton).isVisible();

        boolean isEnabled = page.isEnabled("input");
        if (isEnabled) {
            isLoginSuccess = true;
        }
        return isLoginSuccess;
    }

}
