package com.example.model;

import java.util.ArrayList;
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
	
	@NotNull
	private int loaithue;
	
	@NotNull
	private long tiendatra;
	
	
	private String ghiChu;
	
	@ManyToOne
	@JoinColumn(name = "maP")
	private Phong phong;

	@ManyToMany
	@JoinTable(name = "DSKhach", joinColumns = @JoinColumn(name = "maPTP"), inverseJoinColumns = @JoinColumn(name = "maKH"))
	private List<KhachHang> khachhang=new ArrayList<KhachHang>();

	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanvien;

	@OneToMany(mappedBy = "phieuthuephong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<HoaDon> hoadon=new ArrayList<HoaDon>();
	
	
	public PhieuThuePhong() {
		super();
	}
	
	public PhieuThuePhong(Date ngayBD, int loaithue, long tiendatra, String ghiChu, Phong phong,
			List<KhachHang> khachhang, NhanVien nhanvien) {
		super();
		this.ngayBD = ngayBD;
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
	
	public int getLoaithue() {
		return loaithue;
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
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
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
	public List<HoaDon> getHoadon() {
		return hoadon;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	 

}
