package com.aspose.pdf.cloud.examples.documents;


import com.aspose.pdf.api.PdfApi; import com.aspose.pdf.cloud.Utils;
import com.aspose.pdf.cloud.examples.Configuration;
import com.aspose.pdf.model.Rectangle;
import com.aspose.pdf.model.SaaSposeResponse;
import com.aspose.pdf.model.Signature;
import com.aspose.storage.api.StorageApi; import android.content.Context; import com.aspose.pdf.cloud.R; import java.io.File;


public class SignPDFDocumentsExample {

	public static void execute(Context context) throws Exception {
//ExStart: 1
		String fileName = "sample1-input.pdf";
		String signatureFileName = "pkc7-sample1.pfx";
		int pageNumber = 1;
		String storage = "";
		String folder = "";

		Signature body = new Signature();
		body.setAuthority( "Naeem Akram");
		body.setLocation ( "Gojra");
		body.setContact(  "naeem.akram@aspose.com");
		body.setDate  ("06/24/2015 2:00:00.000 AM");
		body.setFormFieldName ( "Signature1");
		body.setPassword ( "aspose");
		Rectangle rect = new Rectangle();
		rect.setX (100);
		rect.setY (100);
		rect.setHeight ( 100);
		rect.setWidth ( 200);
		body.setRectangle ( rect);
		body.setSignaturePath( signatureFileName);
		body.setSignatureType ( "PKCS7");
		body.setVisible(true);

		//Path inputFile = Utils.getPath(SignPDFDocumentsExample.class, fileName);
		//Path signitureFilePath = Utils.getPath(SignPDFDocumentsExample.class, fileName);

		File input = Utils.stream2file("sample1-input","pdf", context.getResources().openRawResource(R.raw.sample_input));
		File signitureFilePath = Utils.stream2file("pkc7-sample1","pfx", context.getResources().openRawResource(R.raw.pkc7_sample));

		try
		{
			StorageApi storageApi = new StorageApi(Configuration.apiKey, Configuration.appSID, true);
			// Instantiate Aspose Words API SDK
			PdfApi pdfApi = new PdfApi(Configuration.apiKey, Configuration.appSID, true);
		    // Upload source file to aspose cloud storage
		    storageApi.PutCreate(fileName, "", "", input);
		    storageApi.PutCreate(signatureFileName, "", "", signitureFilePath);
		    // Invoke Aspose.PDF Cloud SDK API to sign Pdf document
		    SaaSposeResponse apiResponse = pdfApi.PostSignPage(fileName, pageNumber, storage, folder, body);
		    if (apiResponse != null && apiResponse.getStatus().equals("OK"))
		    {
		    	System.out.println("Sign PDF Documents, Done!");
		    }
		}
		catch (Exception ex)
		{
		    ex.printStackTrace();
		}
//ExEnd:  1
	}
}