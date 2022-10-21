package com.example.demo;

public class Student {
	
	private int id;
	private Mathcheat mathCheat;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMathCheat(Mathcheat mathCheat) {
		this.mathCheat = mathCheat;
	}

	public void cheating() {
		mathCheat.mathCheat();
		System.out.println("Hey my id is :"+id+" take and whatever you want to do..");
		
	}

}
