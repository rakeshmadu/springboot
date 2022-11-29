package com.springvalue.ann;


import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;


public class Student {
	private String name;
	private String intrestedCourse;
	private String hobby;
    
	@Value("${student.name}")
	public void setName(String name) {
        this.name = name;
    }
	@Required
	@Value("${student.intrestedCourse}")
    public void setIntrestedCourse(String intrestedCourse) {
        this.intrestedCourse = intrestedCourse;
    }
	@Value("${student.hobby}")
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
	
    public void displaystudentInfo()
    {
        System.out.println("Student name"+ name);
        System.out.println("Student interested course" + intrestedCourse);
        System.out.println("Student hobby" + hobby);
    }

}
