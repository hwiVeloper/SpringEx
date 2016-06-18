package com.hwi.ex02;

public class Foo {
	private Bar bar;
	//생성자를 통한 주입
	public Foo(Bar bar){
		this.bar = bar;
	}
	
	//설정 메서드를 통한 주입
	public void setBar(Bar bar){
		this.bar = bar;
	}
}
