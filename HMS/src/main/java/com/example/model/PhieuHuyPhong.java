package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "PhieuHuyPhong")
public class PhieuHuyPhong {
	@Id
	@GeneratedValue
	private int maPHP;

	@OneToOne
	@JoinColumn(name = "MaPDP")
	private PhieuDatPhong phieudatphong;

	private long tienphat;
	private long tienconlai;

	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanvien;

	public PhieuHuyPhong() {
		super();
	}

	public PhieuHuyPhong(PhieuDatPhong phieudatphong, long tienphat, long tienconlai, NhanVien nhanvien) {
		super();
		this.phieudatphong = phieudatphong;
		this.tienphat = tienphat;
		this.tienconlai = tienconlai;
		this.nhanvien = nhanvien;
	}

	public PhieuDatPhong getPhieudatphong() {
		return phieudatphong;
	}

	public void setPhieudatphong(PhieuDatPhong phieudatphong) {
		this.phieudatphong = phieudatphong;
	}

	public long getTienphat() {
		return tienphat;
	}

	public void setTienphat(long tienphat) {
		this.tienphat = tienphat;
	}

	public long getTienconlai() {
		return tienconlai;
	}

	public void setTienconlai(long tienconlai) {
		this.tienconlai = tienconlai;
	}

	public NhanVien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public int getMaPHP() {
		return maPHP;
	}

}
