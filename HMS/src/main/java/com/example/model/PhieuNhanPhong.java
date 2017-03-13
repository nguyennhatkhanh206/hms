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
@Table(name = "PhieuNhanPhong")
public class PhieuNhanPhong {

@Id
@GeneratedValue
private int maPNP;

@ManyToOne
@JoinColumn(name = "maNV")
private NhanVien nhanvien;

@NotNull
private Date ngaynhan;

@OneToOne
@JoinColumn(name="maPDP")
private PhieuDatPhong phieudatphong;

public PhieuNhanPhong() {
	super();
}

public PhieuNhanPhong(NhanVien nhanvien, Date ngaynhan, PhieuDatPhong phieudatphong) {
	super();
	this.nhanvien = nhanvien;
	this.ngaynhan = ngaynhan;
	this.phieudatphong = phieudatphong;
}

public NhanVien getNhanvien() {
	return nhanvien;
}

public void setNhanvien(NhanVien nhanvien) {
	this.nhanvien = nhanvien;
}

public Date getNgaynhan() {
	return ngaynhan;
}

public void setNgaynhan(Date ngaynhan) {
	this.ngaynhan = ngaynhan;
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
