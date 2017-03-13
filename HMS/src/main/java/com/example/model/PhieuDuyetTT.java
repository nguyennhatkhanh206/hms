package com.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="PhieuDuyetPhong")
public class PhieuDuyetTT {
	@Id
	@GeneratedValue
	private int maPNP;

	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanvien;

	@NotNull
	private Date ngayduyet;

	@OneToOne
	@JoinColumn(name="maPDP")
	private PhieuDatPhong phieudatphong;

	public PhieuDuyetTT() {
		super();
	}

	public PhieuDuyetTT(NhanVien nhanvien, Date ngayduyet, PhieuDatPhong phieudatphong) {
		super();
		this.nhanvien = nhanvien;
		this.ngayduyet = ngayduyet;
		this.phieudatphong = phieudatphong;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public Date getNgayduyet() {
		return ngayduyet;
	}

	public void setNgayduyet(Date ngayduyet) {
		this.ngayduyet = ngayduyet;
	}

	public PhieuDatPhong getPhieudatphong() {
		return phieudatphong;
	}

	public void setPhieudatphong(PhieuDatPhong phieudatphong) {
		this.phieudatphong = phieudatphong;
	}

	public int getMaPNP() {
		return maPNP;
	}
	
	
}
