package com.example.lcj.jvm.constuct;

/**
 * 静态的是与类有关，会先加载，
 * 而构造代码块是会在对象初始化时执行，
 * 然后再执行构造方法，除非构造方法中含有this()或者super()，
 * 若有，则构造代码块将会在this()或者super()之后执行，
 * 然后再执行构造方法的方法体；
 */
public class Test {
	
	private int number=0;
	
	//静态代码块
	static{
		System.out.println("静态代码块执行！");
	}
	
	//构造代码块
	{
		System.out.println("构造代码块执行！");
		number=1;
	}
	
	//构造方法
	public Test(){
		System.out.println("构造方法执行！");
		System.out.println(number);
	}
	
	
	public static void main(String[] args) {
		new Test();
	}
}
