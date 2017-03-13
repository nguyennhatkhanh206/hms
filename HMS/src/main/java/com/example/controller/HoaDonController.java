package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.HoaDon;
import com.example.model.KhachHang;
import com.example.model.NhanVien;
import com.example.model.PhieuNhanPhong;
import com.example.model.PhieuThuePhong;
import com.example.repository.HoaDonRepository;
import com.example.repository.KhachHangRepository;
import com.example.repository.NhanVienRepository;
import com.example.repository.PhieuThuePhongRepository;

@RestController
@RequestMapping("/hoadon")
public class HoaDonController {
	HoaDonRepository hdRepository;
	NhanVienRepository nvRepository;
	PhieuThuePhongRepository ptpRepository;

	@Autowired
	public HoaDonController(HoaDonRepository hdRepository,NhanVienRepository nvRepository,PhieuThuePhongRepository ptpRepository) {
		this.hdRepository = hdRepository;
		this.nvRepository=nvRepository;
		this.ptpRepository=ptpRepository;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<HoaDon> getall() {
		return hdRepository.findAll();
	}
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public List<HoaDon> create(@RequestBody HoaDon hoadon,@PathVariable int id) {
		HoaDon hd = new HoaDon();
		NhanVien a=nvRepository.findOne("f");
		PhieuThuePhong ptp=ptpRepository.findOne(id);
		hd.setHinhthuctt(hoadon.getHinhthuctt());
		hd.setNgayHD(hoadon.getNgayHD());
		hd.setPhieuthuephong(ptp);
		hd.setTienphong(hoadon.getTienphong());
		hd.setTongtien(hoadon.getTongtien());
		hd.setKtthanhtoan(hoadon.getKtthanhtoan());
		hd.setPhuthu(hoadon.getPhuthu());
		hd.setKhuyenmai(hoadon.getKhuyenmai());
		hd.setNhanvien(a);
		hdRepository.save(hd);
		return hdRepository.findAll();

	}

}
