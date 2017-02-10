package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="DonGia")
public class DonGia implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maDG;

	@NotNull
	private String tenDG;

	@NotNull
	private double giaDemDG;

	@NotNull
	private double giaGioDG;

	@NotNull
	private double phuThuCT;

	// fu thu som 1 gio
	@NotNull
	private double phuThuM;

	// fu thu som 2 gio
	@NotNull
	private double khuyenMai;

	@OneToMany(mappedBy = "dongia",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<LoaiPhong> loaiphong = new ArrayList<LoaiPhong>();

	public DonGia() {
		super();
	}

	public DonGia(String tenDG, double giaDemDG, double giaGioDG, double phuThuCT, double phuThuM, double khuyenMai) {
		super();
		this.tenDG = tenDG;
		this.giaDemDG = giaDemDG;
		this.giaGioDG = giaGioDG;
		this.phuThuCT = phuThuCT;
		this.phuThuM = phuThuM;
		this.khuyenMai = khuyenMai;
	}

	public String getTenDG() {
		return tenDG;
	}

	public void setTenDG(String tenDG) {
		this.tenDG = tenDG;
	}

	public double getGiaDemDG() {
		return giaDemDG;
	}

	public void setGiaDemDG(double giaDemDG) {
		this.giaDemDG = giaDemDG;
	}

	public double getGiaGioDG() {
		return giaGioDG;
	}

	public void setGiaGioDG(double giaGioDG) {
		this.giaGioDG = giaGioDG;
	}

	public double getPhuThuCT() {
		return phuThuCT;
	}

	public void setPhuThuCT(double phuThuCT) {
		this.phuThuCT = phuThuCT;
	}

	public double getPhuThuM() {
		return phuThuM;
	}

	public void setPhuThuM(double phuThuM) {
		this.phuThuM = phuThuM;
	}

	public double getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(double khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public int getMaDG() {
		return maDG;
	}

	public List<LoaiPhong> getLoaiphong() {
		return loaiphong;
	}

	public void setLoaiphong(List<LoaiPhong> loaiphong) {
		this.loaiphong = loaiphong;
	}
	
	
	

}
