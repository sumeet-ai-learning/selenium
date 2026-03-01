package com.triscent.utilities;

import com.microsoft.playwright.Page;
import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BrowserHelper {

    public static void takeScreenShot(Page page, String fileName){
        LocalDate date = LocalDate.now();
        String filePath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"output"+File.separator +
                date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        takeScreenShot(page, filePath, fileName);
    }

    public static void takeScreenShot(Page page, String filePath, String fileName){
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath + File.separator + fileName)));
    }

    public static void wakeUpAfter(long milliSeconconds){
        try {
            Thread.sleep(milliSeconconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}