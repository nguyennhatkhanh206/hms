package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.NhanVien;
import com.example.model.PhieuDatPhong;
import com.example.model.PhieuNhanPhong;
import com.example.repository.NhanVienRepository;
import com.example.repository.PhieuDatPhongRepository;
import com.example.repository.PhieuNhanPhongRepository;

@RestController
@RequestMapping("/phieunhanphong")
public class PhieuNhanPhongController {
	PhieuNhanPhongRepository pnpRepository;
	NhanVienRepository nvRepository;
	@Autowired
	public PhieuNhanPhongController(PhieuNhanPhongRepository pnpRepository,NhanVienRepository nvRepository) {
		this.pnpRepository = pnpRepository;
		this.nvRepository=nvRepository;
        
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<PhieuNhanPhong> getall() {
		return pnpRepository.findAll();
	}


	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<PhieuNhanPhong> create(@RequestBody PhieuNhanPhong prs) {
		PhieuNhanPhong pr=new PhieuNhanPhong();
		NhanVien nv=nvRepository.findOne("f");
		pr.setNgaynhan(prs.getNgaynhan());
		pr.setNhanvien(nv);
		pr.setPhieudatphong(prs.getPhieudatphong());
		pnpRepository.save(pr);
		return pnpRepository.findAll();

	}
}
