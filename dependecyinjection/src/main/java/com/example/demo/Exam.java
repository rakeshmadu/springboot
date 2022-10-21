package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student rakesh = context.getBean("student",Student.class);
		rakesh.displayStudentInfo();
		
		Student dilipN = context.getBean("dilip",Student.class);
		dilipN.displayStudentInfo();
		
	}

}
