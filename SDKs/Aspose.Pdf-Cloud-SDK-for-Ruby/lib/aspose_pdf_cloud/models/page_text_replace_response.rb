module AsposePDFCloud
  # 
  class PageTextReplaceResponse < BaseObject
    attr_accessor :page, :matches, :status, :code
    # attribute mapping from ruby-style variable name to JSON key
    def self.attribute_map
      {
        
        # 
        :'page' => :'Page',
        
        # 
        :'matches' => :'Matches',
        
        # 
        :'status' => :'Status',
        
        # 
        :'code' => :'Code'
        
      }
    end

    # attribute type
    def self.swagger_types
      {
        :'page' => :'Page',
        :'matches' => :'Integer',
        :'status' => :'String',
        :'code' => :'String'
        
      }
    end

    def initialize(attributes = {})
      return if !attributes.is_a?(Hash) || attributes.empty?

      # convert string to symbol for hash key
      attributes = attributes.inject({}){|memo,(k,v)| memo[k.to_sym] = v; memo}

      
      if attributes[:'Page']
        self.page = attributes[:'Page']
      end
      
      if attributes[:'Matches']
        self.matches = attributes[:'Matches']
      end
      
      if attributes[:'Status']
        self.status = attributes[:'Status']
      end
      
      if attributes[:'Code']
        self.code = attributes[:'Code']
      end
      
    end

    def status=(status)
      allowed_values = ["Continue", "SwitchingProtocols", "OK", "Created", "Accepted", "NonAuthoritativeInformation", "NoContent", "ResetContent", "PartialContent", "MultipleChoices", "Ambiguous", "MovedPermanently", "Moved", "Found", "Redirect", "SeeOther", "RedirectMethod", "NotModified", "UseProxy", "Unused", "TemporaryRedirect", "RedirectKeepVerb", "BadRequest", "Unauthorized", "PaymentRequired", "Forbidden", "NotFound", "MethodNotAllowed", "NotAcceptable", "ProxyAuthenticationRequired", "RequestTimeout", "Conflict", "Gone", "LengthRequired", "PreconditionFailed", "RequestEntityTooLarge", "RequestUriTooLong", "UnsupportedMediaType", "RequestedRangeNotSatisfiable", "ExpectationFailed", "UpgradeRequired", "InternalServerError", "NotImplemented", "BadGateway", "ServiceUnavailable", "GatewayTimeout", "HttpVersionNotSupported"]
      if status && !allowed_values.include?(status)
        fail "invalid value for 'status', must be one of #{allowed_values}"
      end
      @status = status
    end

  end
end
