package Utils;

import java.io.File;

public class Constant {

    public static String RESUME_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "Resumes";
    // Resume files path
    public static String RAJU_RESUME_PATH = RESUME_FOLDER_PATH + File.separator + "Raju_Godamwar_SDET_Resume.pdf";
    public static String SUSHANT_RESUME_PATH = RESUME_FOLDER_PATH + File.separator + "Sushant_Jadhav_QA_Engineer.pdf";
    public static String PRIYA_RESUME_PATH = RESUME_FOLDER_PATH + File.separator + "Priya_Yadav_Resume.pdf";


    // Pdf files path
    public static String HR_EMAIL_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "EmailPdf";
    public static String BANG_HR_EMAIL_PATH = HR_EMAIL_PATH + File.separator + "Bangalore_Chennai.pdf";
    public static String HYD_HR_EMAIL_PATH = HR_EMAIL_PATH + File.separator + "Hyderabad.pdf";
    public static String PUNE_HR_EMAIL_PATH = HR_EMAIL_PATH + File.separator + "Pune Mumbai.pdf";
    public static String OTHER_HR_EMAIL_PATH = HR_EMAIL_PATH + File.separator + "Other_Cities.pdf";
    public static String TestingJobs_HR_EMAIL_PATH = HR_EMAIL_PATH + File.separator + "TestingJobs_FullList.pdf";
    public static String WFH_HR_EMAIL_PATH = HR_EMAIL_PATH + File.separator + "WFH Remote Onsite etc.pdf";

}
