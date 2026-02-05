package com.example.lcj.spring.bean.InstantiatingBeans.method04InstanceFactory;

public class American implements Person
{
	private String msg;
	//提供setter方法
	public void setMsg(String msg) 
	{
		this.msg = msg;
	}

	@Override
	public void say() 
	{
		// TODO Auto-generated method stub
		System.out.println(msg+",我要重返亚太地区");
	}
	
}
