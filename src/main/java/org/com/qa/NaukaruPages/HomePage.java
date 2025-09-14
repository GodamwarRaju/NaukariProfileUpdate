package org.com.qa.NaukaruPages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class HomePage {

    private final Page page;

    // Locators

    private final String viewProfileBtn = "//div[@class='view-profile-wrapper']/a[@href='/mnjuser/profile']";
    private final String editSkillBtn = "//span[text()='Key skills']//following-sibling::span[contains(text(),'editOneTheme')]";
    private final String deleteSkillElm = "//span[text()='%s']/following-sibling::a";
    private final String firstSkill = "(//div[@class='waves-effect chip'])[1]//span";
    private final String saveBtn = "//button[text()='Save']";
    private final String searchBox = "input[placeholder='Add skills']";
    private final String addFirstOption = "//div[@class='sugCont slideDown']//li[1]";
    private final String successMsg = "//p[text()='Key Skills have been successfully saved.']";

    public HomePage(Page page) {
        this.page = page;
    }

    /**
     * Navigate to profile page
     */
    public void clickOnViewProfile() {
        page.waitForSelector(viewProfileBtn, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        page.locator(viewProfileBtn).click();
    }

    /**
     * Deletes an existing skill if present
     */
    public String deleteFirstSkillIfPresent(String userSkill) {
        String deleteSkill = userSkill;
        try {
            String val = deleteSkillElm.replace("%s", userSkill);
            page.waitForSelector(val, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
            page.locator(val).click();
            page.locator(saveBtn).click();
        } catch (Exception e) {
            String skillName = page.locator(firstSkill).innerText();
            String val1 = deleteSkillElm.replace("%s", skillName);
            page.waitForSelector(val1, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
            page.locator(val1).click();
            page.locator(saveBtn).click();
            deleteSkill = skillName;
        }
        return deleteSkill;
    }

    /**
     * Adds a new skill
     */
    public void addSkill(String skillName) {
        page.locator(editSkillBtn).click();
        page.locator(searchBox).click();
        page.locator(searchBox).fill(skillName + " ");
        page.locator(searchBox).press("Backspace");
        page.waitForSelector(addFirstOption, new Page.WaitForSelectorOptions()
                .setTimeout(3000)
                .setState(WaitForSelectorState.VISIBLE)); // wait up to 3s for options to appear
        page.locator(addFirstOption).click();
        page.locator(saveBtn).click();
        page.waitForSelector(successMsg, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
    }

    /**
     * Combined action: delete first skill if present, then add new one
     */
    public void addAndDeleteSkill(String skillName) {
        page.locator(editSkillBtn).click();
        String deletedSkill = deleteFirstSkillIfPresent(skillName);
        addSkill(deletedSkill);
    }

    /**
     * Check if home page loaded
     */
    public boolean isHomePageDisplayed() {
        try {
            page.waitForSelector(viewProfileBtn, new Page.WaitForSelectorOptions().setTimeout(3000)); // wait up to 3s
            return page.locator(viewProfileBtn).isVisible();
        } catch (Exception e) {
            return false;
        }
    }

}
