package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DoanKhach;
import com.example.repository.DoanKhachRepository;


@RestController
@RequestMapping("/doankhach")
public class DoanKhachController {
	DoanKhachRepository dkRepository;

	@Autowired
	public DoanKhachController(DoanKhachRepository dkRepository) {
		this.dkRepository = dkRepository;
        
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<DoanKhach> getall() {
		return dkRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<DoanKhach> create(@RequestBody DoanKhach prs) {
		DoanKhach pr = new DoanKhach();
	    pr.setCmndD(prs.getCmndD());
	    pr.setEmailD(prs.getEmailD());
	    pr.setKhachhang(prs.getKhachhang());
	    pr.setSdtD(prs.getSdtD());
	    pr.setTenD(prs.getTenD());
	    pr.setTinhThanhD(prs.getTinhThanhD());
	    pr.setTenTruongD(prs.getTenTruongD());
		dkRepository.save(pr);
		return dkRepository.findAll();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public DoanKhach getupdate(@PathVariable int id) {
		return dkRepository.findOne(id);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json;chaset=UTF-8")
	public DoanKhach postupdate(@RequestBody DoanKhach prs, @PathVariable int id) {
		DoanKhach pr = dkRepository.findOne(id);
		pr.setCmndD(prs.getCmndD());
	    pr.setEmailD(prs.getEmailD());
	    pr.setKhachhang(prs.getKhachhang());
	    pr.setSdtD(prs.getSdtD());
	    pr.setTenD(prs.getTenD());
	    pr.setTinhThanhD(prs.getTinhThanhD());
	    pr.setTenTruongD(prs.getTenTruongD());
		dkRepository.save(pr);
		return dkRepository.findOne(id);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<DoanKhach> remove(@PathVariable int id) {
		dkRepository.delete(id);
		return dkRepository.findAll();

	}
	

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public long sodoankhach(){
		return dkRepository.count();
	}
}
