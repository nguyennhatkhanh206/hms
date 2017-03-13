package com.example.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PhieuDatPhong")
public class PhieuDatPhong {

	@Id
	@GeneratedValue
	private int maPDP;

	@NotNull
	private Date ngaydatPDP;
	
	@NotNull
	private Date ngayvaoPDP;
	
	@NotNull
	private Date ngayraPDP;

	@NotNull
	private int sodemPDP;

	@NotNull
	private Date hanTraPDP;

	@NotNull
	private String tenDK;

	@NotNull
	private String cmndDK;

	@NotNull
	private String emailDK;

	@NotNull
	private int ktthanhtoan;
		
	@NotNull
	private int ktnhanphong;
	@ManyToOne
	@JoinColumn(name = "maHTTT")
	private HinhThucThanhToan hinhthuctt;
	
	
	@ManyToMany
	@JoinTable(name = "CTPhieuDatPhong", joinColumns = @JoinColumn(name = "maPDP"), inverseJoinColumns = @JoinColumn(name = "maP"))
	private List<Phong> phong = new ArrayList<Phong>();
	
	@OneToOne(mappedBy="phieudatphong",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PhieuHuyPhong phieuhuyphong;
	
	@OneToOne(mappedBy="phieudatphong",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private PhieuHuyPhong phieunhanphong;


	public PhieuDatPhong() {
		super();
	}

	public PhieuDatPhong(Date ngaydatPDP, Date ngayvaoPDP, Date ngayraPDP, int sodemPDP, Date hanTraPDP,
			String tenDK, String cmndDK, String emailDK, int ktthanhtoan, int ktnhanphong,
			HinhThucThanhToan hinhthuctt, List<Phong> phong) {
		super();
		this.ngaydatPDP = ngaydatPDP;
		this.ngayvaoPDP = ngayvaoPDP;
		this.ngayraPDP = ngayraPDP;
		this.sodemPDP = sodemPDP;
		this.hanTraPDP = hanTraPDP;
		this.tenDK = tenDK;
		this.cmndDK = cmndDK;
		this.emailDK = emailDK;
		this.ktthanhtoan = ktthanhtoan;
		this.ktnhanphong = ktnhanphong;
		this.hinhthuctt = hinhthuctt;
		this.phong = phong;
	}



	public Date getNgayvaoPDP() {
		return ngayvaoPDP;
	}

	public void setNgayvaoPDP(Date ngayvaoPDP) {
		this.ngayvaoPDP = ngayvaoPDP;
	}

	public Date getNgayraPDP() {
		
		return ngayraPDP;
	}

	public void setNgayraPDP(Date ngayraPDP) {
		this.ngayraPDP = ngayraPDP;
	}

	public int getSodemPDP() {
		return sodemPDP;
	}

	public void setSodemPDP(int sodemPDP) {
		this.sodemPDP = sodemPDP;
	}

	public Date getHanTraPDP() {
		return hanTraPDP;
	}

	public void setHanTraPDP(Date hantra) {
		
		 this.hanTraPDP=hantra;
	
	}

	public String getTenDK() {
		return tenDK;
	}

	public void setTenDK(String tenDK) {
		this.tenDK = tenDK;
	}

	public String getCmndDK() {
		return cmndDK;
	}

	public void setCmndDK(String cmndDK) {
		this.cmndDK = cmndDK;
	}

	public String getEmailDK() {
		return emailDK;
	}

	public void setEmailDK(String emailDK) {
		this.emailDK = emailDK;
	}

	
	public int getKtthanhtoan() {
		return ktthanhtoan;
	}

	public void setKtthanhtoan(int ktthanhtoan) {
		this.ktthanhtoan = ktthanhtoan;
	}

	public List<Phong> getPhong() {
		return phong;
	}

	public void setPhong(List<Phong> phong) {
		this.phong = phong;
	}

	public int getMaPDP() {
		return maPDP;
	}

	
	public HinhThucThanhToan getHinhthuctt() {
		return hinhthuctt;
	}

	public void setHinhthuctt(HinhThucThanhToan hinhthuctt) {
		this.hinhthuctt = hinhthuctt;
	}

	public Date getNgaydatPDP() {
		return ngaydatPDP;
	}

	public void setNgaydatPDP(Date ngaydatPDP) {
		this.ngaydatPDP = ngaydatPDP;
	}

	public int getKtnhanphong() {
		return ktnhanphong;
	}

	public void setKtnhanphong(int ktnhanphong) {
		this.ktnhanphong = ktnhanphong;
	}

	
	
}
