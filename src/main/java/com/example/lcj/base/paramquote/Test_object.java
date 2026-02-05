package com.example.lcj.base.paramquote;

public class Test_object {
	public int i;

	public void star() {
		int a[] = null;
		int i;
		init_a(a);
		for (i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public void init_a(int[] a) {
		int i = 0;
		a = new int[5];
		for (i = 0; i < a.length; i++) a[i] = i++;
	}

	public static void main(String[] args) {
		Test_object to = new Test_object();
		to.star();
	}

}