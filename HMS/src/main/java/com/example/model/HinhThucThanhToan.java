package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "HinhThucTT")
public class HinhThucThanhToan {

	@Id
	@GeneratedValue
	private int maHTTT;
	
	@NotNull
	private String tenHTTT;
	
	@NotNull
	private String motaHTTT;
	
	@OneToMany(mappedBy = "hinhthuctt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PhieuDatPhong> phieudatphong= new ArrayList<PhieuDatPhong>();


	@OneToMany(mappedBy = "hinhthuctt", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HoaDon> hoadon= new ArrayList<HoaDon>();
	
	public HinhThucThanhToan() {
		super();
	}

	public HinhThucThanhToan(String tenHTTT, String motaHTTT) {
		super();
		this.tenHTTT = tenHTTT;
		this.motaHTTT = motaHTTT;
	}

	public String getTenHTTT() {
		return tenHTTT;
	}

	public void setTenHTTT(String tenHTTT) {
		this.tenHTTT = tenHTTT;
	}

	public String getMotaHTTT() {
		return motaHTTT;
	}

	public void setMotaHTTT(String motaHTTT) {
		this.motaHTTT = motaHTTT;
	}

	public int getMaHTTT() {
		return maHTTT;
	}
	
	
}
