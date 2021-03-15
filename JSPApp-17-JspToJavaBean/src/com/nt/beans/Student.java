package com.nt.beans;

import java.io.Serializable;

public class Student implements Serializable {
	private int sno;
	private String sname;
	private float avg;
	
	public Student() {
		System.out.println("Student.0-param - constructor");
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	
}
