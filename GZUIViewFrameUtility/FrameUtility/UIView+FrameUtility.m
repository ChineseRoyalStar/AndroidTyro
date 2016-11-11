//
//  UIView+FrameUtility.m
//  GZUIViewFrameUtility
//
//  Created by armada on 2016/11/11.
//  Copyright © 2016年 com.zlot.gz. All rights reserved.
//

#import "UIView+FrameUtility.h"

@implementation UIView (FrameUtility)

/**
 * @ 获取origin.x
 */
- (UIView* (^)(CGFloat))X {
    
    return ^ UIView*(CGFloat x) {
        CGRect frame = self.frame;
        frame.origin.x = x;
        self.frame = frame;
        return self;
    };
}

/**
 * @ 设置origin.y
 */
- (UIView* (^)(CGFloat))Y {
    
    return ^ UIView*(CGFloat y) {
        CGRect frame = self.frame;
        frame.origin.y = y;
        self.frame = frame;
        return self;
    };
}

/**
 * @ 设置size.width
 */
- (UIView* (^)(CGFloat))Width {
    
    return ^ UIView*(CGFloat width) {
        CGRect frame = self.frame;
        frame.size.width = width;
        self.frame = frame;
        return self;
    };
}

/**
 * @ 设置size.height
 */
- (UIView* (^)(CGFloat))Height {
    
    return ^ UIView*(CGFloat height) {
        CGRect frame = self.frame;
        frame.size.height = height;
        self.frame = frame;
        return self;
    };
}

/**
 * @ 设置center.x
 */
- (UIView* (^)(CGFloat))CenterX {
    
    return ^ UIView*(CGFloat centerX) {
        CGPoint center = self.center;
        center.x = centerX;
        self.center = center;
        return self;
    };
}

/**
 * @ 设置center.y
 */
- (UIView* (^)(CGFloat))CenterY {
    
    return ^ UIView*(CGFloat centerY) {
        CGPoint center = self.center;
        center.y = centerY;
        self.center = center;
        return self;
    };
}

/**
 * @ 设置center
 */
- (UIView* (^)(CGPoint))Center {
    
    return ^ UIView*(CGPoint center) {
        self.center = center;
        return self;
    };
}

/**
 * @ 设置size
 */
- (UIView* (^)(CGSize))Size {
    
    return ^ UIView*(CGSize size) {
        CGRect frame = self.frame;
        frame.size = size;
        self.frame = frame;
        return self;
    };
}

#pragma mark - Frameset methods

- (void)setX:(CGFloat)x
{
    CGRect frame = self.frame;
    frame.origin.x = x;
    self.frame = frame;
}

- (CGFloat)x
{
    return self.frame.origin.x;
}

- (void)setY:(CGFloat)y
{
    CGRect frame = self.frame;
    frame.origin.y = y;
    self.frame = frame;
}

- (CGFloat)y
{
    return self.frame.origin.y;
}

- (void)setWidth:(CGFloat)width
{
    CGRect frame = self.frame;
    frame.size.width = width;
    self.frame = frame;
}

- (CGFloat)width
{
    return self.frame.size.width;
}

- (void)setHeight:(CGFloat)height
{
    CGRect frame = self.frame;
    frame.size.height = height;
    self.frame = frame;
}

- (CGFloat)height
{
    return self.frame.size.height;
}

- (CGSize)size{
    return self.frame.size;
}

- (void)setSize:(CGSize)size{
    CGRect frame = self.frame;
    frame.size = size;
    self.frame = frame;
}

- (CGFloat)centerX{
    return self.frame.origin.x;
}

- (void)setCenterX:(CGFloat)centerX{
    CGRect frame = self.frame;
    frame.origin.x = centerX;
    self.frame = frame;
}

- (CGFloat)centerY{
    return self.frame.origin.y;
}

- (void)setCenterY:(CGFloat)centerY{
    CGRect frame = self.frame;
    frame.origin.y = centerY;
    self.frame = frame;
}

@end
