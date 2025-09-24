package Utils;

import java.io.File;

public class Constant {

   public static String RESUME_FOLDER_PATH = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Resumes";
   public  static String RAJU_RESUME_PATH = RESUME_FOLDER_PATH+File.separator+"Raju_Godamwar_SDET_Resume.pdf";

   // Pdf files path
    public static String HR_EMAIL_PATH = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"EmailPdf";
    public static String HYD_HR_EMAIL_PATH = HR_EMAIL_PATH+File.separator+"Bangalore_Chennai.pdf";
}
