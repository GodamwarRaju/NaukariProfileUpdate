package org.com.qa.NaukriTest;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtractHREmailsFromPDF {

    public static void main(String[] args) {
        String pdfFilePath = "C:\\Users\\HP\\Downloads\\HREmailIDs\\Pune Mumbai.pdf"; // your PDF file path
        extractEmails(pdfFilePath);
    }
    public static void extractEmails(String filePath) {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            // Extract text from PDF
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            // Regex to match emails ending with .com or .in
            Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|in)");
            Matcher matcher = emailPattern.matcher(text);
            Set<String> uniqueEmails = new HashSet<>();
            while (matcher.find()) {
                uniqueEmails.add(matcher.group());
            }
            System.out.println("Extracted Email IDs:");
            uniqueEmails.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
