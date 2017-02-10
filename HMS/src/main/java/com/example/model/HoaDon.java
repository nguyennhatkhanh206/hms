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
	private long khachtra;
	
	
	public HoaDon() {
		super();
	}

	

	public HoaDon(PhieuThuePhong phieuthuephong, Date ngayHD, long tongtien, long khachtra) {
		super();
		this.phieuthuephong = phieuthuephong;
		this.ngayHD = ngayHD;
		this.tongtien = tongtien;
		this.khachtra = khachtra;
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
		this.tongtien = tongtien;
	}

	public int getMaHD() {
		return maHD;
	}



	public long getKhachtra() {
		return khachtra;
	}



	public void setKhachtra(long khachtra) {
		this.khachtra = khachtra;
	}
	
	

}
