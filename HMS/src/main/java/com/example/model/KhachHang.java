package com.example.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "KhachHang")
public class KhachHang {
	
	@Id
	private String cmndKH;

	@NotNull
	private String hoTenKH;

	@NotNull
	private String queQuanKH;

	@NotNull
	private String sdtKH;

	@NotNull
	private int tichluyKH;


	@ManyToMany(mappedBy = "khachhang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DoanKhach> doankhach = new ArrayList<DoanKhach>();

	@ManyToMany(mappedBy = "khachhang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PhieuThuePhong> phieuthuephong = new ArrayList<PhieuThuePhong>();

	public KhachHang() {
		super();
	}

	public KhachHang(String hoTenKH, String cmndKH, String queQuanKH, String sdtKH, Date ngaysinhKH, int tichluyKH) {
		super();
		this.hoTenKH = hoTenKH;
		this.cmndKH = cmndKH;
		this.queQuanKH = queQuanKH;
		this.sdtKH = sdtKH;
		this.tichluyKH = tichluyKH;
	}


	public String getHoTenKH() {
		return hoTenKH;
	}

	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}

	public String getCmndKH() {
		return cmndKH;
	}

	public void setCmndKH(String cmndKH) {
		this.cmndKH = cmndKH;
	}

	public String getQueQuanKH() {
		return queQuanKH;
	}

	public void setQueQuanKH(String queQuanKH) {
		this.queQuanKH = queQuanKH;
	}

	public String getSdtKH() {
		return sdtKH;
	}

	public void setSdtKH(String sdtKH) {
		this.sdtKH = sdtKH;
	}

	public int getTichluyKH() {
		return tichluyKH;
	}

	public void setTichluyKH(int tichluyKH) {
		this.tichluyKH = tichluyKH;
	}

}