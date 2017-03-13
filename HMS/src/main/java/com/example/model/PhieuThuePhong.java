package com.example.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "PhieuThuePhong")
public class PhieuThuePhong {

	@Id
	@GeneratedValue
	private int maPTP;
	
	@NotNull
	private Date ngayBD;
	
	private Date ngayTP;
	
	@NotNull
	private int loaithue;
	
	@NotNull
	private long tiendatra;
	
	@NotNull
	private long sodem;
	
	@NotNull
	private long sogio;
	
	private String ghiChu;
	
	@ManyToOne
	@JoinColumn(name = "maP")
	private Phong phong;

	@ManyToMany
	@JoinTable(name = "DSKhach", joinColumns = @JoinColumn(name = "maPTP"), inverseJoinColumns = @JoinColumn(name = "cmndKH"))
	private List<KhachHang> khachhang=new ArrayList<KhachHang>();

	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanvien;
	
	@ManyToMany
	@JoinTable(name = "DSDoanPTP", joinColumns = @JoinColumn(name = "maPTP"), inverseJoinColumns = @JoinColumn(name = "maDK"))
	private List<DoanKhach> doankhach=new ArrayList<DoanKhach>();

	@OneToMany(mappedBy = "phieuthuephong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HoaDon> hoadon=new ArrayList<HoaDon>();
	
	
	public PhieuThuePhong() {
		super();
	}
	
	
	public PhieuThuePhong(Date ngayBD, Date ngayTP, int loaithue, long tiendatra, String ghiChu,
			Phong phong, List<KhachHang> khachhang, NhanVien nhanvien, List<DoanKhach> doankhach) {
		super();
		this.ngayBD = ngayBD;
		this.ngayTP = ngayTP;
		this.loaithue = loaithue;
		this.tiendatra = tiendatra;
		this.ghiChu = ghiChu;
		this.phong = phong;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
		this.doankhach = doankhach;
	
	}

	public PhieuThuePhong(Date ngayBD, Date ngayTP, int loaithue, long tiendatra, String ghiChu,
			Phong phong, List<KhachHang> khachhang, NhanVien nhanvien) {
		super();
		this.ngayBD = ngayBD;
		this.ngayTP = ngayTP;
		this.loaithue = loaithue;
		this.tiendatra = tiendatra;
		this.ghiChu = ghiChu;
		this.phong = phong;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
	
	}

	public Date getNgayBD() {
		return ngayBD;
	}
	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}
	
	
	public Date getNgayTP() {
		return ngayTP;
	}

	public void setNgayTP(Date ngayTP) {
		this.ngayTP = ngayTP;
	}

	public int getLoaithue() {
		return loaithue;
	}
	
	public String getTenLT(){
		if(this.loaithue==1)
			return "Đêm";
		else
			return "Giờ";
	}
	public long getQuaGio(){
		Date now=new Date();
		long ngay=now.getTime()-this.ngayTP.getTime();
		long gio=(ngay/ (60 * 60 * 1000) % 24);
		if(gio>0)
			return gio;
		else return 0;
	}
	public void setLoaithue(int loaithue) {
		this.loaithue = loaithue;
	}
	public long getTiendatra() {
		return tiendatra;
	}
	public void setTiendatra(long tiendatra) {
		this.tiendatra = tiendatra;
	}
	
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	
	
	public Phong getPhong() {
		return phong;
	}




	public List<KhachHang> getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(List<KhachHang> khachhang) {
		this.khachhang = khachhang;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public int getMaPTP() {
		return maPTP;
	}
	
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


    
	public void setSodem() {
		long ngay=this.ngayBD.getTime()-this.ngayTP.getTime();
		this.sodem = ngay/(24 * 60 * 60 * 1000);
	}




	public long getSodem() {
		return sodem;
	}


	
	public void setSogio() {
		long ngay=this.ngayBD.getTime()-this.ngayTP.getTime();
		this.sogio =ngay/ (60 * 60 * 1000) % 24;
	}




	public long getSogio() {
		return sogio;
	}



	public List<DoanKhach> getDoankhach() {
		return doankhach;
	}




	public void setDoankhach(List<DoanKhach> doankhach) {
		this.doankhach = doankhach;
	}
	 

}
