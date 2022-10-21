package com.spring.aw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {
	@Autowired
	@Qualifier("humanHeart")
	private Heart heart;
	public Human() {
		// TODO Auto-generated constructor stub
	}

	
	public Human(Heart heart) {
		this.heart = heart;
		System.out.println("human constructor getting called which as heart as argument");
	}
	
	public void setHeart(Heart heart) {
		this.heart = heart;
		System.out.println("setter method called");
	}

	public void startPumping() {
		if (heart != null) {
			heart.pump();
			System.out.println("name of animal is " + heart.getNameOfAnimal() +","+
					" no of heart present:" + heart.getNoOfHeart());
		} else {
			System.out.println("heart not pumping");
		}
	}

}
