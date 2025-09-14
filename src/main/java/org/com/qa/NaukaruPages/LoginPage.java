package org.com.qa.NaukaruPages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;

    // Locators
    private final String emailInput = "input[placeholder='Enter Email ID / Username']";
    private final String passwordInput = "input[placeholder='Enter Password']";
    private final String loginButton = "//button[text()='Login']";

    public LoginPage(Page page) {
        this.page = page;
    }

    // Action: login and return HomePage
    public HomePage login(String userName, String password) {
        page.locator(emailInput).fill(userName);
        page.locator(passwordInput).fill(password);
        page.locator(loginButton).click();
        return new HomePage(page);
    }

    // Optional: verify login page loaded
    public boolean isLoginPageDisplayed() {
        return page.locator(loginButton).isVisible();
    }
}
