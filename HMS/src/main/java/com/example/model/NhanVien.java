package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "NhanVien")
public class NhanVien {

	@Id
	private String maNV;

	@NotNull
	private String tenNV;

	@NotNull
	private String diaChiNV;

	@NotNull
	private String sdtNV;

	@NotNull
	private Date ngaySinhNV;

	@NotNull
	private Date ngayLamNV;

	@NotNull
	private String matKhauNV;

	@NotNull
	private int quyenNV;
	
	@OneToMany(mappedBy = "nhanvien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PhieuThuePhong> phieuthuephong=new ArrayList<PhieuThuePhong>();
	
	@OneToMany(mappedBy="nhanvien")
	private List<PhieuHuyPhong> phieuhuyphong=new ArrayList<PhieuHuyPhong>();

	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String tenNV, String diaChiNV, String sdtNV, Date ngaySinhNV, Date ngayLamNV,
			String matKhauNV, int quyenNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChiNV = diaChiNV;
		this.sdtNV = sdtNV;
		this.ngaySinhNV = ngaySinhNV;
		this.ngayLamNV = ngayLamNV;
		this.matKhauNV = matKhauNV;
		this.quyenNV = quyenNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getDiaChiNV() {
		return diaChiNV;
	}

	public void setDiaChiNV(String diaChiNV) {
		this.diaChiNV = diaChiNV;
	}

	public String getSdtNV() {
		return sdtNV;
	}

	public void setSdtNV(String sdtNV) {
		this.sdtNV = sdtNV;
	}

	public Date getNgaySinhNV() {
		return ngaySinhNV;
	}

	public void setNgaySinhNV(Date ngaySinhNV) {
		this.ngaySinhNV = ngaySinhNV;
	}

	public Date getNgayLamNV() {
		return ngayLamNV;
	}

	public void setNgayLamNV(Date ngayLamNV) {
		this.ngayLamNV = ngayLamNV;
	}

	public String getMatKhauNV() {
		return matKhauNV;
	}

	public void setMatKhauNV(String matKhauNV) {
		this.matKhauNV = matKhauNV;
	}

	public int getQuyenNV() {
		return quyenNV;
	}

	public void setQuyenNV(int quyenNV) {
		this.quyenNV = quyenNV;
	}

}
