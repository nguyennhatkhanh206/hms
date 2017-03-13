package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Phong")
public class Phong implements Serializable {

	@Id
	private String maP;

	@NotNull
	private String trangThaiP;

	@ManyToOne
	@JoinColumn(name = "maLP")
	private LoaiPhong loaiphong;

	@ManyToMany(mappedBy = "phong",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PhieuDatPhong> phieudatphong = new ArrayList<PhieuDatPhong>();

	@OneToMany(mappedBy = "phong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PhieuThuePhong> phieuthuephong = new ArrayList<PhieuThuePhong>();
    
	public Phong() {
		super();
	}

	public Phong(String maP, String trangThaiP, LoaiPhong loaiphong) {
		super();
		this.maP = maP;
		this.trangThaiP = trangThaiP;
		this.loaiphong = loaiphong;
	}

	public String getMaP() {
		return maP;
	}

	public void setMaP(String maP) {
		this.maP = maP;
	}

	public String getTrangThaiP() {
		return trangThaiP;
	}

	public void setTrangThaiP(String trangThaiP) {
		this.trangThaiP = trangThaiP;
	}

	public int getMaLP() {
		return loaiphong.getMaLP();
	}

	public String getTenLP() {
		return loaiphong.getTenLP();
	}

	public void setLoaiphong(LoaiPhong loaiphong) {
		this.loaiphong = loaiphong;
	}

}
