#import <Foundation/Foundation.h>
#import "ASPObject.h"

/**
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

#import "ASPLink.h"


@protocol ASPDocumentProperty
@end

@interface ASPDocumentProperty : ASPObject


@property(nonatomic) NSString* name;

@property(nonatomic) NSString* value;

@property(nonatomic) NSNumber* builtIn;

@property(nonatomic) NSArray<ASPLink>* links;

@end
