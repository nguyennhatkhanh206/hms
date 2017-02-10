package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PhieuDatPhong;
import com.example.repository.PhieuDatPhongRepository;


@RestController
@RequestMapping("/phieudathong")
public class PhieuDatPhongController {
	PhieuDatPhongRepository pdpRepository;
	@Autowired
	public PhieuDatPhongController(PhieuDatPhongRepository pdpRepository) {
		this.pdpRepository = pdpRepository;
        
		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<PhieuDatPhong> getall() {
		return pdpRepository.findAll();
	}


	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<PhieuDatPhong> create(@RequestBody PhieuDatPhong prs) {
		PhieuDatPhong pr=new PhieuDatPhong();
		pdpRepository.save(pr);
		return pdpRepository.findAll();

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public PhieuDatPhong getupdate(@PathVariable int id) {

		return pdpRepository.findOne(id);
 
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST,produces="application/json;chaset=UTF-8")
	public PhieuDatPhong postupdate(@RequestBody PhieuDatPhong prs, @PathVariable int id) {		
		PhieuDatPhong pr=pdpRepository.findOne(id);
		pdpRepository.save(pr);
		return pdpRepository.findOne(id);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<PhieuDatPhong> remove(@PathVariable int id) {
		pdpRepository.delete(id);
		return pdpRepository.findAll();

	}
	
	
}
