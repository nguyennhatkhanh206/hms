package com.huongxinhdep;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




@Entity
@Table(name="sinhvien")
public class SinhVien {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@NotNull
private String name;

@NotNull
private String address;



public SinhVien() {
	super();
}


public SinhVien(int id, String name, String address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}


public int getId() {
	return id;
}


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}


}
