#ExStart:
require 'aspose_pdf_cloud'

class DocumentProperty

  include AsposePDFCloud
  include AsposeStorageCloud

  def initialize
    #Get App key and App SID from https://cloud.aspose.com
    AsposeApp.app_key_and_sid("APP_KEY", "APP_SID")
    @pdf_api = PdfApi.new  
  end

  def upload_file(file_name)
    @storage_api = StorageApi.new 
    response = @storage_api.put_create(file_name, File.open("../../../data/" << file_name,"r") { |io| io.read } )
  end

  # Read document property by name.
  def read_document_property_by_name
    file_name = "Sample-Annotation.pdf"
    upload_file(file_name)

    response = @pdf_api.delete_properties(file_name)
  end

end

documentProperty = DocumentProperty.new()
puts documentProperty.read_document_property_by_name
#ExEnd: