package org.com.qa.NaukriTest;

import Utils.Constant;
import Utils.EmailUtils;
import Utils.ExtractHREmailsFromPDF;
import org.testng.annotations.Test;

import java.util.Set;

import static Utils.Constant.HYD_HR_EMAIL_PATH;
import static Utils.Constant.RAJU_RESUME_PATH;
import static Utils.EmailData.RAJU_EMAIL_BODY;
import static Utils.EmailData.RAJU_EMAIL_SUBJECT;


public class SendEmailTest {
    @Test
    public void sendEmail() {
        ExtractHREmailsFromPDF extractHREmailsFromPDF = new ExtractHREmailsFromPDF();
        Set<String> emails = extractHREmailsFromPDF.extractEmails(HYD_HR_EMAIL_PATH);
        EmailUtils emailUtils = new EmailUtils();
        for(String email: emails){
            emailUtils.sendEmail("rajugodamwar@gmail.com","phqsuaaykrdufiav",email, RAJU_EMAIL_SUBJECT ,RAJU_EMAIL_BODY,RAJU_RESUME_PATH);
        }
        System.out.println("Total Email Sent to HR is :"+emails.size());
    }
}