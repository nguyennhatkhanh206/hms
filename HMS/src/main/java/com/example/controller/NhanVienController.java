package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.NhanVien;
import com.example.repository.NhanVienRepository;

@RestController
@RequestMapping("/nhanvien")
public class NhanVienController {
	NhanVienRepository nvRepository;

	@Autowired
	public NhanVienController(NhanVienRepository nvRepository) {
		this.nvRepository = nvRepository;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<NhanVien> getall() {
		return nvRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<NhanVien> create(@RequestBody NhanVien nv) {

		NhanVien nhanVien = new NhanVien();
		nhanVien.setMaNV(nv.getMaNV());
		nhanVien.setTenNV(nv.getTenNV());
		nhanVien.setMatKhauNV(nv.getMatKhauNV());
		nhanVien.setDiaChiNV(nv.getDiaChiNV());
		nhanVien.setNgayLamNV(nv.getNgayLamNV());
		nhanVien.setSdtNV(nv.getSdtNV());
		nhanVien.setNgaySinhNV(nv.getNgaySinhNV());
		nhanVien.setQuyenNV(nv.getQuyenNV());
		nvRepository.save(nhanVien);	
		return nvRepository.findAll();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public NhanVien getupdate(@PathVariable String id) {

		return nvRepository.findOne(id);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST,produces="application/json;chaset=UTF-8")
	public NhanVien postupdate(@RequestBody NhanVien nv, @PathVariable String id) {
		NhanVien nhanVien = nvRepository.findOne(id);
		nhanVien.setMaNV(nv.getMaNV());
		nhanVien.setTenNV(nv.getTenNV());
		nhanVien.setMatKhauNV(nv.getMatKhauNV());
		nhanVien.setDiaChiNV(nv.getDiaChiNV());
		nhanVien.setNgayLamNV(nv.getNgayLamNV());
		nhanVien.setSdtNV(nv.getSdtNV());
		nhanVien.setNgaySinhNV(nv.getNgaySinhNV());
		nhanVien.setQuyenNV(nv.getQuyenNV());
		nvRepository.save(nhanVien);	
		return nvRepository.findOne(id);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<NhanVien> remove(@PathVariable String id) {
		nvRepository.delete(id);
		return nvRepository.findAll();

	}
}
