package com.keane.training.domain;

public class Rented {
	int id;
	String vehicle_no;
	String feedback;
	public Rented(int id, String vehicle_no, String feedback) {
		super();
		this.id = id;
		this.vehicle_no = vehicle_no;
		this.feedback = feedback;
	}
	
	public Rented(int id,String vehicle_no)
	{
		this.id=id;
		this.vehicle_no=vehicle_no;
	}
	public Rented() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Rented [id=" + id + ", vehicle_no=" + vehicle_no + ", feedback=" + feedback + "]";
	}

}
