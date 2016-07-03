package com.hwi.ex03;

public class MessageBeanImpl implements MessageBean{
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void sayHello(){
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){}
		
		System.out.println("Hello, " + name + "!");
	}
}