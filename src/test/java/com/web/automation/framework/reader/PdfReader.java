package com.web.automation.framework.reader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PdfReader {



    public static String readPDFContent(String documentURL) throws IOException {
        URL url=new URL(documentURL);
        InputStream inputStream=url.openStream();
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream);
        PDDocument pdDocument=PDDocument.load(bufferedInputStream);
        String content=new PDFTextStripper().getText(pdDocument);
        pdDocument.close();
        return content;
    }
}
