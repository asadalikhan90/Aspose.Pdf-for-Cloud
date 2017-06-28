package com.aspose.pdf.cloud.text;


import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import com.aspose.pdf.api.PdfApi;
import com.aspose.pdf.cloud.examples.Configuration;
import com.aspose.pdf.cloud.examples.Utils;
import com.aspose.pdf.cloud.images.ExtractImageDefaultSizeExample;
import com.aspose.pdf.model.DocumentTextReplaceResponse;
import com.aspose.pdf.model.TextReplace;
import com.aspose.pdf.model.TextReplaceListRequest;
import com.aspose.storage.api.StorageApi;


public class ReplaceMultipleTextsInPDFDocument {

	public static void main(String[] args) {
		String fileName = "sample-input.pdf";
		String storage = "";
		String folder = "";

		TextReplaceListRequest body = new TextReplaceListRequest();
		TextReplace tr1 = new TextReplace();
		tr1.setOldValue( "Sample");
		tr1.setNewValue ( "Aspose Sample");
		TextReplace tr2 = new TextReplace();
		tr2.setOldValue ("PDF");
		tr2.setNewValue ( "PDF Document");
		TextReplace[] arr={ tr1, tr2 };
		body.setTextReplaces ( new ArrayList<TextReplace> (Arrays.asList(arr)));
		Path inputFile = Utils.getPath(ExtractImageDefaultSizeExample.class, fileName);

		try
		{
			StorageApi storageApi = new StorageApi(Configuration.apiKey, Configuration.appSID, true);
			// Instantiate Aspose Words API SDK
			PdfApi pdfApi = new PdfApi(Configuration.apiKey, Configuration.appSID, true);
		    // Upload source file to aspose cloud storage
		    storageApi.PutCreate(fileName, "", "", inputFile.toFile());

		    // Invoke Aspose.PDF Cloud SDK API to replace multiple text in PDF
		    DocumentTextReplaceResponse apiResponse = pdfApi.PostDocumentReplaceTextList(fileName, storage, folder, body);

		    if (apiResponse != null && apiResponse.getStatus().equals("OK"))
		    {
		    	System.out.println("Replace Multiple Texts in a PDF, Done!");
		    }
		}
		catch (Exception ex)
		{
		    ex.printStackTrace();
		}
	}

}