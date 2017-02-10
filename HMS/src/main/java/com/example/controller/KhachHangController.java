package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.KhachHang;
import com.example.model.LoaiPhong;
import com.example.model.NhanVien;
import com.example.model.PhieuThuePhong;
import com.example.repository.KhachHangRepository;

@RestController
@RequestMapping("/khachhang")
public class KhachHangController {
	KhachHangRepository khRepository;

	@Autowired
	public KhachHangController(KhachHangRepository khRepository) {
		this.khRepository = khRepository;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<KhachHang> getall() {
		return khRepository.findAll();
	}

	@RequestMapping(value = "/search/{cmnd}", method = RequestMethod.GET)
	public KhachHang seach(@PathVariable String cmnd) {
		return khRepository.findOne(cmnd);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<KhachHang> create(@RequestBody KhachHang khachhang) {
		KhachHang kh = new KhachHang();
		kh.setCmndKH(khachhang.getCmndKH());
		kh.setHoTenKH(khachhang.getHoTenKH());
		kh.setSdtKH(khachhang.getSdtKH());
		kh.setQueQuanKH(khachhang.getQueQuanKH());
		kh.setTichluyKH(khachhang.getTichluyKH());
		khRepository.save(kh);
		return khRepository.findAll();

	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json;chaset=UTF-8")
	public KhachHang postupdate(@RequestBody KhachHang khachhang,@PathVariable String id) {
		KhachHang kh = khRepository.findOne(id);
		kh.setCmndKH(khachhang.getCmndKH());
		kh.setHoTenKH(khachhang.getHoTenKH());
		kh.setSdtKH(khachhang.getSdtKH());
		kh.setQueQuanKH(khachhang.getQueQuanKH());
		kh.setTichluyKH(khachhang.getTichluyKH()+1);
		khRepository.save(kh);
		return khRepository.findOne(id);

	}
}
