package com.keane.training.domain;

public class Vehicle {
	private String vno;
	private String vtype;
	private String vname;
	private int price;
	private String status;
	private int discount;
	public Vehicle(String vno, String vtype, String vname, int price, String status,int discount) {
		super();
		this.vno = vno;
		this.vtype = vtype;
		this.vname = vname;
		this.price = price;
		this.status = status;
		this.discount=discount;
	}
	public String getVno() {
		return vno;
	}
	public void setVno(String vno) {
		this.vno = vno;
	}
	public String getVtype() {
		return vtype;
	}
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Vehicle(String vno,String vtype,String vname,int price )
	{
		super();
		this.vno=vno;
		this.vtype=vtype;
		this.vname=vname;
		this.price=price;
	}
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Vehicle [vno=" + vno + ", vtype=" + vtype + ", vname=" + vname + ", price=" + price + ", status="
				+ status + "]";
	}
	
	
	
	
	
	

}
