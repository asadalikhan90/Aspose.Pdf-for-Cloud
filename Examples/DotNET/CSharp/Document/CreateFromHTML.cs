﻿using System;
using Com.Aspose.PDF.Api;
using Com.Aspose.PDF.Model;
using Com.Aspose.Storage.Api;

namespace Document
{
    class CreateFromHTML
    {
        public static void Run()
        {
            // ExStart:1
            PdfApi pdfApi = new PdfApi(Common.APP_KEY, Common.APP_SID, Common.BASEPATH);
            StorageApi storageApi = new StorageApi(Common.APP_KEY, Common.APP_SID, Common.BASEPATH);

            String fileName = "input.pdf";
            String templateFile = "sample.html";
            String dataFile = "";
            String templateType = "html";
            String storage = "";
            String folder = "";

            try
            {
                // Upload source file to aspose cloud storage
                storageApi.PutCreate(templateFile, "", "", System.IO.File.ReadAllBytes(Common.GetDataDir() + templateFile));

                // Invoke Aspose.PDF Cloud SDK API to create pdf file from HTML
                DocumentResponse apiResponse = pdfApi.PutCreateDocument(fileName, templateFile, dataFile, templateType, storage, folder);

                if (apiResponse != null && apiResponse.Status.Equals("OK"))
                {
                    Console.WriteLine("Create Empty HTML, Done!");
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
