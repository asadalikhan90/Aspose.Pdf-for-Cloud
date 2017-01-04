﻿using System;
using Com.Aspose.PDF.Api;
using Com.Aspose.PDF.Model;
using Com.Aspose.Storage.Api;

namespace Document
{
    class CreatePdfFromTIFF
    {
        public static void Run()
        {
            // ExStart:1
            PdfApi pdfApi = new PdfApi(Common.APP_KEY, Common.APP_SID, Common.BASEPATH);
            StorageApi storageApi = new StorageApi(Common.APP_KEY, Common.APP_SID, Common.BASEPATH);

            String fileName = "sample-tiff.pdf";
            String templateFile = "Sample.tiff";
            String dataFile = "";
            String templateType = "tiff";
            String storage = "";
            String folder = "";

            try
            {
                // Upload source file to aspose cloud storage
                storageApi.PutCreate(templateFile, "", "", System.IO.File.ReadAllBytes(Common.GetDataDir() + templateFile));

                // Invoke Aspose.PDF Cloud SDK API to create pdf from TIFF
                DocumentResponse apiResponse = pdfApi.PutCreateDocument(fileName, templateFile, dataFile, templateType, storage, folder);

                if (apiResponse != null && apiResponse.Status.Equals("OK"))
                {
                    Console.WriteLine("Create PDF from TIFF, Done!");
                    Console.ReadKey();
                }
            }
            catch (Exception ex)
            {
                System.Diagnostics.Debug.WriteLine("error:" + ex.Message + "\n" + ex.StackTrace);
            }
            // ExEnd:1
        }
    }
}
