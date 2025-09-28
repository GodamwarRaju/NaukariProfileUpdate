package org.com.qa.NaukriTest;

import static Utils.Constant.HYD_HR_EMAIL_PATH;
import static Utils.Constant.PUNE_HR_EMAIL_PATH;
import static Utils.Constant.BANG_HR_EMAIL_PATH;
import static Utils.Constant.WFH_HR_EMAIL_PATH;
import static Utils.Constant.TestingJobs_HR_EMAIL_PATH;
import static Utils.Constant.OTHER_HR_EMAIL_PATH;

import static Utils.Constant.RAJU_RESUME_PATH;
import static Utils.EmailData.RAJU_EMAIL_BODY;
import static Utils.EmailData.RAJU_EMAIL_SUBJECT;
import static Utils.Constant.SUSHANT_RESUME_PATH;
import static Utils.EmailData.SUSHANT_EMAIL_BODY;
import static Utils.EmailData.SUSHANT_EMAIL_SUBJECT;

import Utils.EmailUtils;
import Utils.ExtractHREmailsFromPDF;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;



public class SendEmailTest {

    ArrayList <String> filesPaths = (ArrayList<String>) Arrays.asList(
            WFH_HR_EMAIL_PATH,
            PUNE_HR_EMAIL_PATH,
            HYD_HR_EMAIL_PATH,
            BANG_HR_EMAIL_PATH,
            TestingJobs_HR_EMAIL_PATH,
            OTHER_HR_EMAIL_PATH
            );

    private String rajuEmailPassKey = "phqsuaaykrdufiav";
    private String sushantEmailPassKey = "khejraffnvojznnb";
	
    @Test
    public void sendEmail() {
    	
        for(String filePath:filesPaths){
            Set<String> HR_Emails = ExtractHREmailsFromPDF.extractEmails(filePath);
            EmailUtils emailUtils = new EmailUtils();
            emailUtils.sendEmailToBCC("rajugodamwar@gmail.com",rajuEmailPassKey,HR_Emails,RAJU_EMAIL_SUBJECT,RAJU_EMAIL_BODY,RAJU_RESUME_PATH);
            System.out.println("Total Email Sent to HR is :"+HR_Emails.size());
        }
    }
    
    @Test
    public void sendEmailSushant() {
        for (String file : filesPaths) {
		        Set<String> emails = ExtractHREmailsFromPDF.extractEmails(file);
		        EmailUtils emailUtils = new EmailUtils();
		        for(String email: emails){
		            emailUtils.sendEmailTo("sushj2405@gmail.com",sushantEmailPassKey,email, SUSHANT_EMAIL_SUBJECT ,SUSHANT_EMAIL_BODY,SUSHANT_RESUME_PATH);
		        }
		        System.out.println("Total Email Sent to HR is :"+emails.size());
		        }
    }
}