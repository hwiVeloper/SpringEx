package com.hwi.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.hwi.ex02.MessageBean;

public class HelloApp {
	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("beans_ex02.xml"));
		MessageBean bean = factory.getBean("messageBean", MessageBean.class);
		bean.sayHello();
	}
}
