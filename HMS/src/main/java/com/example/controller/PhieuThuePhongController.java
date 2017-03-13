package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.NhanVien;
import com.example.model.PhieuThuePhong;
import com.example.model.Phong;
import com.example.repository.NhanVienRepository;
import com.example.repository.PhieuThuePhongRepository;
import com.example.repository.PhongRepository;



@RestController
@RequestMapping("/phieuthuephong")
public class PhieuThuePhongController {

	PhieuThuePhongRepository ptpRepository;
	NhanVienRepository nvRepository;
	PhongRepository pRepository;

	    @Autowired
		public PhieuThuePhongController(PhieuThuePhongRepository ptpRepository,NhanVienRepository nvRepository,PhongRepository pRepository) {
			this.ptpRepository = ptpRepository;
			this.nvRepository= nvRepository;
	        this.pRepository= pRepository;
			
		}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<PhieuThuePhong> getall() {
		return ptpRepository.findAll();
	}

	@RequestMapping(value = "/add/{map}", method = RequestMethod.POST)
	public List<PhieuThuePhong> create(@RequestBody PhieuThuePhong prs,@PathVariable String map) {
		PhieuThuePhong pr = new PhieuThuePhong();
		NhanVien a=nvRepository.findOne("f");
	    Phong phong=pRepository.findOne(map);
		pr.setKhachhang(prs.getKhachhang());
		pr.setLoaithue(prs.getLoaithue());
		pr.setDoankhach(prs.getDoankhach());
		pr.setNhanvien(a);
		pr.setNgayBD(prs.getNgayBD());
		pr.setNgayTP(prs.getNgayTP());
		pr.setTiendatra(prs.getTiendatra());
		pr.setGhiChu(prs.getGhiChu());
		pr.setPhong(phong);
		ptpRepository.save(pr);
		return ptpRepository.findAll();

	}
	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public PhieuThuePhong getupdate(@PathVariable int id) {

		return ptpRepository.findOne(id);

	}

	@RequestMapping(value = "/update/{id}/{maP}", method = RequestMethod.POST, produces = "application/json;chaset=UTF-8")
	public PhieuThuePhong postupdate(@RequestBody PhieuThuePhong prs, @PathVariable int id,@PathVariable String maP) {
		PhieuThuePhong pr = ptpRepository.findOne(id);
		NhanVien a=nvRepository.findOne("f");
		Phong phong=pRepository.findOne(maP);
		pr.setPhong(phong);
		ptpRepository.save(pr);
		return ptpRepository.findOne(id);

	}
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<PhieuThuePhong> remove(@PathVariable int id) {
		ptpRepository.delete(id);
		return ptpRepository.findAll();

	}
	
	@RequestMapping(value = "/sophieu/{id}", method = RequestMethod.GET)
	public Long sophieu(@PathVariable String id) {
		Phong phong=pRepository.findOne(id) ;	
		long sophieu=ptpRepository.countByPhong(phong);
		return sophieu;

	}
	@RequestMapping(value = "/dsphong/{id}", method = RequestMethod.GET)
	public List<PhieuThuePhong> timthuephong(@PathVariable String id) {
		Phong phong=pRepository.findOne(id) ;	
		return ptpRepository.findAllByPhong(phong);
	}
	
	@RequestMapping(value = "/dsthue/{id}", method = RequestMethod.GET)
	public List<PhieuThuePhong> saungaythue(@PathVariable String id) {
		Date ngaythue=new Date(id);	
		return ptpRepository.findByNgayTPAfter(ngaythue);
	}

}
