package com.example.model;

import java.util.ArrayList;
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
	private Date checkinPDP;

	@NotNull
	private Date checkoutPDP;

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
	private String sdtDK;

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
	
	@OneToOne(mappedBy="phieudatphong")
	private PhieuHuyPhong phieuhuyphong;

	public PhieuDatPhong() {
		super();
	}

	public PhieuDatPhong(Date checkinPDP, Date checkoutPDP, int sodemPDP, Date hanTraPDP, String tenDK, String cmndDK,
			String emailDK, String sdtDK, int ktthanhtoan, List<Phong> phong) {
		super();
		this.checkinPDP = checkinPDP;
		this.checkoutPDP = checkoutPDP;
		this.sodemPDP = sodemPDP;
		this.hanTraPDP = hanTraPDP;
		this.tenDK = tenDK;
		this.cmndDK = cmndDK;
		this.emailDK = emailDK;
		this.sdtDK = sdtDK;
		this.ktthanhtoan = ktthanhtoan;
		this.phong = phong;
	}

	public Date getCheckinPDP() {
		return checkinPDP;
	}

	public void setCheckinPDP(Date checkinPDP) {
		this.checkinPDP = checkinPDP;
	}

	public Date getCheckoutPDP() {
		return checkoutPDP;
	}

	public void setCheckoutPDP(Date checkoutPDP) {
		this.checkoutPDP = checkoutPDP;
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

	public void setHanTraPDP(Date hanTraPDP) {
		this.hanTraPDP = hanTraPDP;
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

	public String getSdtDK() {
		return sdtDK;
	}

	public void setSdtDK(String sdtDK) {
		this.sdtDK = sdtDK;
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

}
