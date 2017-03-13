package com.example.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="HoaDonDP")
public class HoaDonDP {
	@Id
	@GeneratedValue
	private int maHD;

	@OneToOne
	@JoinColumn(name = "maPDDP")
	private PhieuDatPhong phieudatphong;
	@NotNull
	private Date ngayHD;
	
	@NotNull
	private long tienphong;
	
	@NotNull
	private long tongtien;
	
	@NotNull
	private long phuthu;

	@NotNull
	private long khachdatra;

	@ManyToOne
	@JoinColumn(name = "maHTTT")
	private HinhThucThanhToan hinhthuctt;

	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanvien;

	public HoaDonDP() {
		super();
	}

	public HoaDonDP(PhieuDatPhong phieudatphong, Date ngayHD, long tienphong, long tongtien, long phuthu,
			long khachdatra, HinhThucThanhToan hinhthuctt, NhanVien nhanvien) {
		super();
		this.phieudatphong = phieudatphong;
		this.ngayHD = ngayHD;
		this.tienphong = tienphong;
		this.tongtien = tongtien;
		this.phuthu = phuthu;
		this.khachdatra = khachdatra;
		this.hinhthuctt = hinhthuctt;
		this.nhanvien = nhanvien;
	}

	public PhieuDatPhong getPhieudatphong() {
		return phieudatphong;
	}

	public void setPhieudatphong(PhieuDatPhong phieudatphong) {
		this.phieudatphong = phieudatphong;
	}

	public Date getNgayHD() {
		return ngayHD;
	}

	public void setNgayHD(Date ngayHD) {
		this.ngayHD = ngayHD;
	}

	public long getTienphong() {
		return tienphong;
	}

	public void setTienphong(long tienphong) {
		this.tienphong = tienphong;
	}

	public long getTongtien() {
		return tongtien;
	}

	public void setTongtien(long tongtien) {
		this.tongtien = tongtien;
	}

	public long getPhuthu() {
		return phuthu;
	}

	public void setPhuthu(long phuthu) {
		this.phuthu = phuthu;
	}

	public long getKhachdatra() {
		return khachdatra;
	}

	public void setKhachdatra(long khachdatra) {
		this.khachdatra = khachdatra;
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

	public int getMaHD() {
		return maHD;
	}
	
	

}
