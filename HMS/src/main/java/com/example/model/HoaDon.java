package com.example.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
	@Id
	@GeneratedValue
	private int maHD;

	@ManyToOne
	@JoinColumn(name = "maPTP")
	private PhieuThuePhong phieuthuephong;
	@NotNull
	private Date ngayHD;
	@NotNull
	private long tongtien;
	
	@NotNull
	private long tienphong;
	
	@NotNull
	private long khuyenmai;
	
	@NotNull
	private long phuthu;

	@NotNull
	private int ktthanhtoan;

	@ManyToOne
	@JoinColumn(name = "maHTTT")
	private HinhThucThanhToan hinhthuctt;

	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanvien;

	public HoaDon() {
		super();
	}

	public HoaDon(PhieuThuePhong phieuthuephong, Date ngayHD, long tongtien, long khachtra,long khuyenmai,
			HinhThucThanhToan hinhthuctt, NhanVien nhanvien, int ktthanhtoan) {
		super();
		this.phieuthuephong = phieuthuephong;
		this.ngayHD = ngayHD;
		this.tongtien = tongtien;
		this.hinhthuctt = hinhthuctt;
		this.nhanvien = nhanvien;
		this.khuyenmai=khuyenmai;
		this.ktthanhtoan=ktthanhtoan;
	}

	public PhieuThuePhong getPhieuthuephong() {
		return phieuthuephong;
	}

	public void setPhieuthuephong(PhieuThuePhong phieuthuephong) {
		this.phieuthuephong = phieuthuephong;
	}

	public Date getNgayHD() {
		return ngayHD;
	}

	public void setNgayHD(Date ngayHD) {
		this.ngayHD = ngayHD;
	}

	public long getTongtien() {
		return tongtien;
	}

	public void setTongtien(long tongtien) {
		this.tongtien = tienphong+phuthu;
	}

	public HinhThucThanhToan getHinhthuctt() {
		return hinhthuctt;
	}

	public void setHinhthuctt(HinhThucThanhToan hinhthuctt) {
		this.hinhthuctt = hinhthuctt;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public long getTienphong() {
		return tienphong;
	}

	public void setTienphong(long tienphong) {
		this.tienphong = tienphong;
	}

	public long getPhuthu() {
		return phuthu;
	}

	public void setPhuthu(long phuthu) {
		this.phuthu = phuthu;
	}

	public int getKtthanhtoan() {
		return ktthanhtoan;
	}

	public void setKtthanhtoan(int ktthanhtoan) {
		this.ktthanhtoan = ktthanhtoan;
	}

	public int getMaHD() {
		return maHD;
	}

	public long getKhuyenmai() {
		return khuyenmai;
	}

	public void setKhuyenmai(long khuyenmai) {
		this.khuyenmai = khuyenmai;
	}
	
	

}
