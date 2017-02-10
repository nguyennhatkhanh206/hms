package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "LoaiPhong")
public class LoaiPhong implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maLP;

	@NotNull
	private String tenLP;
	@NotNull
	private int dienTichLP;
	@NotNull
	private String moTaLP;
	@NotNull
	private int soNguoiLP;

	@NotNull
	private int soGiuongLP;

	@OneToMany(mappedBy = "loaiphong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Phong> phong = new ArrayList<Phong>();

	@ManyToOne
	@JoinColumn(name = "maDG")
	private DonGia dongia;

	public LoaiPhong() {
		super();

	}

	public LoaiPhong(String tenLP, int dienTichLP, String moTaLP, int soNguoiLP, int soGiuongLP, DonGia dongia) {
		super();
		this.tenLP = tenLP;
		this.dienTichLP = dienTichLP;
		this.moTaLP = moTaLP;
		this.soNguoiLP = soNguoiLP;
		this.soGiuongLP = soGiuongLP;
		this.dongia = dongia;
	}

	public String getTenLP() {
		return tenLP;
	}

	public void setTenLP(String tenLP) {
		this.tenLP = tenLP;
	}

	public int getDienTichLP() {
		return dienTichLP;
	}

	public void setDienTichLP(int dienTichLP) {
		this.dienTichLP = dienTichLP;
	}

	public String getMoTaLP() {
		return moTaLP;
	}

	public void setMoTaLP(String moTaLP) {
		this.moTaLP = moTaLP;
	}

	public int getSoNguoiLP() {
		return soNguoiLP;
	}

	public void setSoNguoiLP(int soNguoiLP) {
		this.soNguoiLP = soNguoiLP;
	}

	public int getSoGiuongLP() {
		return soGiuongLP;
	}

	public void setSoGiuongLP(int soGiuongLP) {
		this.soGiuongLP = soGiuongLP;
	}

	public List<Phong> getPhong() {
		return phong;
	}

	public void setPhong(List<Phong> phong) {
		this.phong = phong;
	}

	public void setDongia(DonGia dongia) {
		this.dongia = dongia;
	}

	public int getMaLP() {
		return maLP;
	}

	public String getTenDG() {
		return dongia.getTenDG();
	}

	public int getMaDG() {
		return dongia.getMaDG();
	}

}
