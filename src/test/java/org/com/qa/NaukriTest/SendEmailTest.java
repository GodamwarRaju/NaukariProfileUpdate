package org.com.qa.NaukriTest;

import static Utils.Constant.HYD_HR_EMAIL_PATH;
import static Utils.Constant.PUNE_HR_EMAIL_PATH;
import static Utils.Constant.BANG_HR_EMAIL_PATH;
import static Utils.Constant.TestingJobs_HR_EMAIL_PATH;
import static Utils.Constant.RAJU_RESUME_PATH;
import static Utils.Constant.SUSHANT_RESUME_PATH;
import static Utils.Constant.WFH_HR_EMAIL_PATH;
import static Utils.EmailData.RAJU_EMAIL_BODY;
import static Utils.EmailData.RAJU_EMAIL_SUBJECT;
import static Utils.EmailData.SUSHANT_EMAIL_BODY;
import static Utils.EmailData.SUSHANT_EMAIL_SUBJECT;

import java.util.ArrayList;
import java.util.Set;

import org.testng.annotations.Test;

import Utils.EmailUtils;
import Utils.ExtractHREmailsFromPDF;


public class SendEmailTest {
	
public ArrayList <String>  allHrEmails() {
     ArrayList <String> files = new ArrayList<String>();
     files.add(WFH_HR_EMAIL_PATH);
     files.add(PUNE_HR_EMAIL_PATH);
     files.add(HYD_HR_EMAIL_PATH);
     files.add(BANG_HR_EMAIL_PATH);
     files.add(TestingJobs_HR_EMAIL_PATH);
     return files;
}

	
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
    
    @Test
    public void sendEmailSushant() {
        ExtractHREmailsFromPDF extractHREmailsFromPDF = new ExtractHREmailsFromPDF();
    	 ArrayList <String> filesPath =allHrEmails();
        for (String file : filesPath) {
		        Set<String> emails = extractHREmailsFromPDF.extractEmails(file);
		        EmailUtils emailUtils = new EmailUtils();
		        for(String email: emails){
		            emailUtils.sendEmail("sushj2405@gmail.com","khejraffnvojznnb",email, SUSHANT_EMAIL_SUBJECT ,SUSHANT_EMAIL_BODY,SUSHANT_RESUME_PATH);
		        }
		        System.out.println("Total Email Sent to HR is :"+emails.size());
		        }
    }
}