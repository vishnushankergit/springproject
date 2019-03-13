package com.first.dozer;

public class TCSEmployee {
	private double id;
	private String name;
	private double tcsSaliry;
	
	public TCSEmployee(){}
	
	public TCSEmployee(int id, String name, double tcsSaliry) {
        super();
        this.id = id;
        this.name = name;
        this.tcsSaliry = tcsSaliry;
    }
	
	public double getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTcsSaliry() {
		return tcsSaliry;
	}
	public void setTcsSaliry(double tcsSaliry) {
		this.tcsSaliry = tcsSaliry;
	}
	


}
