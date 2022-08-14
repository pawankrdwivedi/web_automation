package com.web.automation.framework.reader;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils
{
    static String userDirectory=System.getProperty("user.dir")+"/";

    public static String getFileDetails(String path,String fileName,String detailName){
        String fileDetails=null;
        File file=new File(userDirectory+path+"/"+fileName);
        switch(detailName.toLowerCase()){
            case "name":
                fileDetails=file.getName();
                break;
            case "path":
                fileDetails=file.getAbsolutePath();
                break;
            case "modified":
                fileDetails=new DateTime(file.lastModified())
                        .toString(DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss"))
                        .replaceAll("/", "_").replaceAll(":", "_")
                        .replaceAll(" ", "_");
                break;
            default:
                System.err.print("Invalid detailName"+detailName);
        }
        return fileDetails;
    }

    public static void copyCourgetteReportsInHistory(){
        try
        {
            String courgetteLatestPath="testreport/cucumber/latest/courgette-";
            String courgetteHistoryPath="testreport/cucumber/history/courgette-";

            String fileName=getFileDetails(courgetteLatestPath+"report","index.html","modified");

            File src=new File(userDirectory+courgetteLatestPath+"report/index.html");
            File dest=new File(userDirectory+courgetteHistoryPath+"report/"+"Cucumber_Report_"+fileName+".html");
            Files.copy(src.toPath(),dest.toPath());
            File src1=new File(userDirectory+courgetteLatestPath+"extentreports/index.html");
            File dest1=new File(userDirectory+courgetteHistoryPath+"extentreports/"+"Extent_Report_"+fileName+".html");
            Files.copy(src1.toPath(),dest1.toPath());

        } catch (IOException e) {
            //throw new RuntimeException(e);
        }
    }
}
