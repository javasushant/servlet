package com.nt.dto;

public class EmployeeDTO {
	private String Ename;
	private String Eadd;
	private int basicSal;
	private int hra;
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getEadd() {
		return Eadd;
	}
	public void setEadd(String eadd) {
		Eadd = eadd;
	}
	public int getBasicSal() {
		return basicSal;
	}
	public void setBasicSal(int basicSal) {
		this.basicSal = basicSal;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [Ename=" + Ename + ", Eadd=" + Eadd + ", basicSal=" + basicSal + ", hra=" + hra + "]";
	}
	
	
	
}
