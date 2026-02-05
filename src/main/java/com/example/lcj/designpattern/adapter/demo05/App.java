package com.example.lcj.designpattern.adapter.demo05;

public class App {
 
 
	public static void main(String[] args) {
		//没有与外系统连接的时候，是这样写的
		//IUserInfo youngGirl = new UserInfo();
		
		//老板一想不对呀，兔子不吃窝边草，还是找人力资源的员工好点
		IOuterUserBaseInfo outerUserBaseInfo = new OuterUserBaseInfo();
		IOuterUserHomeInfo outerUserHomeInfo = new OuterUserHomeInfo();
		IOuterUserOfficeInfo outerUserOfficeInfo = new OuterUserOfficeInfo();
		IUserInfo youngGirl = new OuterUserInfo(outerUserBaseInfo,outerUserHomeInfo,outerUserOfficeInfo);  //我们只修改了这一句好
		//从数据库中查到101个
		for(int i=0;i<101;i++){
			youngGirl.getMobileNumber();
		}		
	}
}
