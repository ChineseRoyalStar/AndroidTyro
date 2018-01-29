//
//  ViewController.m
//  GZUIViewFrameUtility
//
//  Created by armada on 2016/11/11.
//  Copyright © 2016年 com.zlot.gz. All rights reserved.
//

#import "ViewController.h"

#import "UIView+FrameUtility.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    UIView *redView = [UIView new];
    redView.X(100).Y(20).Width(50).Height(100);
    redView.backgroundColor = [UIColor redColor];
    [self.view addSubview:redView];
    
    UIView *blueView = [UIView new];
    blueView.Center(CGPointMake(150, 300)).Size(CGSizeMake(100, 50));
    blueView.backgroundColor = [UIColor blueColor];
    [self.view addSubview:blueView];

}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
