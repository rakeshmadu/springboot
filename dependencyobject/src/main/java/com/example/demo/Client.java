package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("beans.xml file loaded");
		Student student = context.getBean("stu",Student.class);
		student.cheating();
		AnotherStudent another = context.getBean("another",AnotherStudent.class);
		another.startCheating();
	}

}
