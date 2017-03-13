package com.example.model;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "DoanKhach")
public class DoanKhach {

	@Id
	@GeneratedValue
	private int maDK;
	
	@NotNull
	private String tenD;
	
	@NotNull
	private String tenTruongD;
	
	@NotNull
	private String cmndD;
	
	@NotNull
	private String tinhThanhD;
	
	@NotNull
	private String emailD;
	
	@NotNull
	private String sdtD;
	
	

	@ManyToMany(mappedBy = "doankhach", cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PhieuThuePhong> phieuthuephong =new ArrayList<PhieuThuePhong>();
	

	@ManyToMany
	@JoinTable(name = "DSDoankhach",joinColumns = @JoinColumn(name = "maDK"), inverseJoinColumns = @JoinColumn(name = "cmndKH"))
	private List<KhachHang> khachhang=new ArrayList<KhachHang>();

	public DoanKhach() {
		super();
	}

	public DoanKhach(String tenD, String tenTruongD, String cmndD, String tinhThanhD, String emailD, String sdtD) {
		super();
		this.tenD = tenD;
		this.tenTruongD = tenTruongD;
		this.cmndD = cmndD;
		this.tinhThanhD = tinhThanhD;
		this.emailD = emailD;
		this.sdtD = sdtD;
	
	}
	
	public DoanKhach(String tenD, String tenTruongD, String cmndD, String tinhThanhD, String emailD, String sdtD,
			List<KhachHang> khachhang) {
		super();
		this.tenD = tenD;
		this.tenTruongD = tenTruongD;
		this.cmndD = cmndD;
		this.tinhThanhD = tinhThanhD;
		this.emailD = emailD;
		this.sdtD = sdtD;
		this.khachhang = khachhang;
	}
	
	
	public DoanKhach(String tenD, String tenTruongD, String cmndD, String tinhThanhD, String emailD, String sdtD,
			List<PhieuThuePhong> phieuthuephong, List<KhachHang> khachhang) {
		super();
		this.tenD = tenD;
		this.tenTruongD = tenTruongD;
		this.cmndD = cmndD;
		this.tinhThanhD = tinhThanhD;
		this.emailD = emailD;
		this.sdtD = sdtD;
		this.phieuthuephong = phieuthuephong;
		this.khachhang = khachhang;
	}

	public String getTenD() {
		return tenD;
	}

	public void setTenD(String tenD) {
		this.tenD = tenD;
	}

	public String getTenTruongD() {
		return tenTruongD;
	}

	public void setTenTruongD(String tenTruongD) {
		this.tenTruongD = tenTruongD;
	}

	public String getCmndD() {
		return cmndD;
	}

	public void setCmndD(String cmndD) {
		this.cmndD = cmndD;
	}

	public String getTinhThanhD() {
		return tinhThanhD;
	}

	public void setTinhThanhD(String tinhThanhD) {
		this.tinhThanhD = tinhThanhD;
	}

	public String getEmailD() {
		return emailD;
	}

	public void setEmailD(String emailD) {
		this.emailD = emailD;
	}

	public String getSdtD() {
		return sdtD;
	}

	public void setSdtD(String sdtD) {
		this.sdtD = sdtD;
	}

	public List<KhachHang> getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(List<KhachHang> khachhang) {
		this.khachhang = khachhang;
	}

	public int getMaDK() {
		return maDK;
	}

	
	

	
}
