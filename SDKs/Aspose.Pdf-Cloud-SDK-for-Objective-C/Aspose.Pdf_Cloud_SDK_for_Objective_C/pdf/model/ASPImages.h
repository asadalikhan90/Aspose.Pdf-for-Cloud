#import <Foundation/Foundation.h>
#import "ASPObject.h"

/**
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */

#import "ASPLink.h"
#import "ASPImage.h"


@protocol ASPImages
@end

@interface ASPImages : ASPObject


@property(nonatomic) NSArray<ASPImage>* list;

@property(nonatomic) NSArray<ASPLink>* links;

@end